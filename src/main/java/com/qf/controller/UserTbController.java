package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.StudentInter;
import com.qf.bean.UserTb;
import com.qf.service.UserTbMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserTbController {

    @Resource
    private UserTbMapperService userTbMapperService;

    /**
     * 登录
     */
    @RequestMapping("/login")
    public void login(String TxtUserName, String TxtPassword, HttpServletResponse response, HttpSession session){

        UserTb userTb=userTbMapperService.login(TxtUserName,TxtPassword);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if(userTb==null){
                out.println("<script>alert('用户名或密码不正确');location.href='login.jsp'</script>");
            }else{
                session.setAttribute("user",userTb);
                out.println("<script>alert('登录成功');location.href='index.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 退出
     */
    @RequestMapping("/out")
    public String quit(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }
    /**
     * 验证用户名
     */
    @RequestMapping("/user/checkname")
    public void checkname(String uname,HttpServletResponse response){
        boolean checkname=userTbMapperService.checkname(uname);

        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if(checkname){
                out.println("用户名已存在");
            }else{
                out.print("用户名可用");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 更新
     */
    @RequestMapping("/user/updateuser")
    public void updateuser(UserTb userTb,HttpSession session,HttpServletResponse response){
        UserTb u2=userTbMapperService.updateusers(userTb);
        try {
            PrintWriter out=response.getWriter();
            if(u2!=null){
                session.setAttribute("user",u2);
                out.print("<script>top.location.href='/index.jsp'</script>");
            }else{
                out.print("<script>location.href='/MyUser.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 用户管理:全查,分页,模糊查
     */
    @RequestMapping("/power/user/findalluser")
    public String findalluser(@RequestParam(defaultValue="1")int index, ModelMap map){
        PageInfo<UserTb> pageInfo = userTbMapperService.findall(index, StudentInter.PAGESIZE);
        map.addAttribute("pageInfo",pageInfo);
        return "/power/user/list";
    }

}
