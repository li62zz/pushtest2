package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.StudentInter;
import com.qf.bean.Classes;
import com.qf.bean.Department;
import com.qf.bean.Major;
import com.qf.bean.UserTb;
import com.qf.service.ClassesMapperService;
import com.qf.service.DepartmentMapperService;
import com.qf.service.MajorMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ClassesController {

    @Resource
    private ClassesMapperService classesMapperService;

    @Resource
    private DepartmentMapperService departmentMapperService;

    @Resource
    private MajorMapperService majorMapperService;


    /**
     * 班级管理 全查和分页,模糊查
     */
    @RequestMapping("/Educational/class/selectallcla")
    public String findall(ModelMap map,@RequestParam(defaultValue = "1") int index,String classesname){
        PageInfo<Classes> pageInfo = classesMapperService.findall(index, StudentInter.PAGESIZE, classesname);
        map.addAttribute("pageInfo",pageInfo);
        map.addAttribute("cla",classesname);
        return "/Educational/class/list";
    }
    /**
     * 班级管理 提交审核
     */


    @RequestMapping("/Educational/class/submitaudit")
    public String submitaudit(Classes classes,HttpSession session){
        classes.setClassstate("审核中");
        //设置审核人的id
        UserTb userTb=(UserTb)session.getAttribute("user");
        classes.setAuditid(userTb.getManagerid());
        //审核次数
        Classes classes1=classesMapperService.selectByPrimaryKey(classes.getClassid());
        classes.setAuditcount(classes1.getAuditcount()+1);
        int i=classesMapperService.updateByPrimaryKeySelective(classes);
        return "redirect:/Educational/class/selectallcla";
    }

    /**
     *班级审核全查
     */
    @RequestMapping("Educational/Auditing")
    public String audit(ModelMap map, String classnum, String classname, @RequestParam(defaultValue = "1") int index, HttpSession session){
        UserTb userTb = (UserTb)session.getAttribute("user");
        PageInfo<Classes> pageInfo=classesMapperService.selectaudit(index,StudentInter.PAGESIZE,classnum,classname,userTb.getUserId());
        map.put("pageInfo",pageInfo);
        map.put("classnum",classnum);
        map.put("classname",classname);
        return "/Educational/Auditing";
    }
    /**
     * 修改state
     */
    @RequestMapping("Educational/updatestate/{a1}/{b1}")
    public String audit(@PathVariable(name="a1") int classid,@PathVariable(name="b1") int state){
        Classes classes=new Classes();
        classes.setClassid(classid);
        switch (state){
            case 1:
                classes.setClassstate("审核通过");
                break;
            case 2:
                classes.setClassstate("审核未通过");
                break;
        }
        classesMapperService.updateByPrimaryKeySelective(classes);
        return "redirect:/Educational/Auditing";

    }

    /**
     * 查询所有学院信息
     */
    @RequestMapping("/Educational/class/selectdepts")
    public String getdepts(ModelMap map){
        List<Department> departmentList = departmentMapperService.findall();
        map.addAttribute("dlist",departmentList);
        return "/Educational/class/add";
    }

    /**
     * 查询所有专业信息
     */
    @RequestMapping("/Educatioal/class/findmajorbyid")
    @ResponseBody
    public List getmajor(int deptid){
        List<Major> list = majorMapperService.findbydeptid(deptid);
        return list;
    }

    /**
     * 查询班主任
     */
    @RequestMapping("/Educatinoal/class/findclassbyid")
    @ResponseBody
    public List getTeacher(int mid){
        List<String> tlist = classesMapperService.findteacher(mid);
        return tlist;
    }

    /**
     * 添加班级信息
     */
    @RequestMapping("Educational/class/add")
    public String add(Classes classes){

        classes.setClassstate("未审核");
        classes.setAuditcount(0);
        int i = classesMapperService.insertSelective(classes);

        if(i>0) {
            return "redirect:/Educational/class/selectallcla";
        }else {
            return "/Educational/class/selectdepts";
        }

    }



}
