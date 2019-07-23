package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.StudentInter;
import com.qf.bean.*;
import com.qf.dao.MajorMapper;
import com.qf.service.ClassesMapperService;
import com.qf.service.DepartmentMapperService;
import com.qf.service.ExamMapperService;
import com.qf.service.StudentMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ExamController {

    @Resource
    private ExamMapperService examMapperService;

    @Resource
    private DepartmentMapperService departmentMapperService;

    @Resource
    private MajorMapper majorMapper;

    @Resource
    private ClassesMapperService classesMapperService;

    @Resource
    private StudentMapperService studentMapperService;

    /**
     * 考试列表全查 分页 模糊查
     */
    @RequestMapping("Educational/exam/findlist")
    public String findexam(@RequestParam(defaultValue = "1") int index, String examsubject, ModelMap map){
        PageInfo<Exam> pageInfo = examMapperService.findexam(index, StudentInter.PAGESIZE, examsubject);
        map.addAttribute("examsubject",examsubject);
        map.addAttribute("pageInfo",pageInfo);
        return "Educational/exam/exam";
    }

    /**
     * 查询所有院系
     */
    @RequestMapping("/Educational/exam/findalldept")
    public String findalldept(ModelMap map){
        List<Department> departmentList = departmentMapperService.findall();
        map.addAttribute("dlist",departmentList);
        return "/Educational/exam/add";
    }

    /**
     * 查询所有专业
     */
    @RequestMapping("/Educational/exam/findallmajor")
    @ResponseBody
    public List<Major> findbydeptid(int deptid){
        List<Major> majors = majorMapper.findbydeptid(deptid);
        return majors;
    }
    /**
     * 查询所有班级
     */
    @RequestMapping("/Educational/exam/findclassbyid")
    @ResponseBody
    public List<Classes> findcla(int mid){
        List<Classes> classesList = classesMapperService.findbimid(mid);
        return classesList;
    }

    /**
     * 新增考试
     */
    @RequestMapping("/Educational/exam/addexam")
    public String addexam(Exam exam){

        int i=examMapperService.insertSelective(exam);

        if(i>0){
            return "redirect:/Educational/exam/findlist";
        }else {
            return "/Educational/exam/findalldept";
        }
    }

    /**
     * 主键查询考试信息
     */
    @RequestMapping("/Educational/exam/findbyid")
    public String findbyid(int examid,ModelMap map){
        Exam exam = examMapperService.findbyid(examid);
        map.addAttribute("exam",exam);
        return "/Educational/exam/view";
    }

    /**
     * 组织补考,主键查询
     */
    @RequestMapping("/Educational/exam/findbyeid")
    public String selecteid(int examid,ModelMap map){
        Exam exam=examMapperService.findbyid(examid);
        map.addAttribute("exam",exam);

        List<Department> departmentList = departmentMapperService.findall();
        map.addAttribute("deptlist",departmentList);

        List<Major> majorList = majorMapper.findbydeptid(exam.getDeptid());
        map.addAttribute("majorlist",majorList);

        List<Classes> classesList = classesMapperService.findbimid(exam.getMajorid());
        map.addAttribute("clalist",classesList);

        return "/Educational/exam/reAdd";
    }

    /**
     * 修改考试成绩
     */
    @RequestMapping("/Educational/exam/updatescore")
    @ResponseBody
    public String updatescore(int examid,int studentid,int score,HttpServletResponse response){

        int i=studentMapperService.updatescore(examid,studentid,score);
        response.setContentType("text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            return "修改成功";
        }
        return "修改失败";
    }

    /**
     * 修改考试信息,主键查询
     */
    @RequestMapping("/Educational/exam/selectbyeid")
    public String selectbyeid(int examid,ModelMap map){
        Exam exam = examMapperService.findbyid(examid);
        map.addAttribute("exam",exam);

        List<Department> departmentList = departmentMapperService.findall();
        map.addAttribute("deptlist",departmentList);

        List<Major> majorList = majorMapper.findbydeptid(exam.getDeptid());
        map.addAttribute("majorlist",majorList);

        List<Classes> classesList = classesMapperService.findbimid(exam.getMajorid());
        map.addAttribute("clalist",classesList);


        return "/Educational/exam/update";
    }

    /**
     * 修改考试信息
     */
    @RequestMapping("/Educational/exam/updateexambyid")
    public void update(Exam exam,HttpServletResponse response){
        int i = examMapperService.updateByPrimaryKeySelective(exam);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if(i>0){
                out.print("<script>alert('更新成功');location.href='/Educational/exam/findlist'</script>");
            }else{
                out.print("<script>alert('更新失败');location.href='/Educational/exam/selectbyeid'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 组织补考,添加考试
     */
    @RequestMapping("/Educational/exam/readd")
    public void readdexam(Exam exam,HttpServletResponse response){
        int i = examMapperService.insertSelective(exam);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if(i>0){
                out.print("<script>alert('新增成功');location.href='/Educational/exam/findlist'</script>");
            }else{
                out.print("<script>alert('新增失败');location.href='/Educational/exam/findbyeid'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除考试
     */
    @RequestMapping("/Educational/exam/deletebyid")
    public void delteexam(int examid, HttpServletResponse response){
        int i=examMapperService.deleteByPrimaryKey(examid);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if(i>0){
                out.print("<script>alert('删除成功');location.href='/Educational/exam/findlist'</script>");
            }else {
                out.print("<script>alert('删除失败');location.href='Educational/exam/findlist'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询该科所有考生的成绩
     */
    @RequestMapping("/Educational/exam/findexam")
    public String findexam(@RequestParam(defaultValue = "1") int index, String stuname,int examid, ModelMap map, HttpSession session){
        PageInfo<Student> pageInfo = studentMapperService.findscore(index, StudentInter.PAGESIZE, examid, stuname);
        map.addAttribute("stu",stuname);
        map.addAttribute("pageInfo",pageInfo);
        session.setAttribute("examid",examid);

        return "/Educational/exam/list";
    }
}
