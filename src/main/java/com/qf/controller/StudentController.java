package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.StudentInter;
import com.qf.bean.Classes;
import com.qf.bean.Department;
import com.qf.bean.Major;
import com.qf.bean.Student;
import com.qf.service.DepartmentMapperService;
import com.qf.service.MajorMapperService;
import com.qf.service.StudentMapperService;
import com.qf.service.impl.ClassesMapperServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    private StudentMapperService studentMapperService;

    @Resource
    private DepartmentMapperService departmentMapperService;

    @Resource
    private MajorMapperService majorMapperService;

    @Resource
    private ClassesMapperServiceImpl classesMapperService;

    /**
     *查询学生列表 分页 模糊查
     */
    @RequestMapping("Educational/student/selectall")
    public String getstudents(ModelMap map,@RequestParam(defaultValue="1")int index,String stuname,String stuno,@RequestParam(defaultValue = "-1") int stusex){
        PageInfo pageInfo=studentMapperService.findall(index, StudentInter.PAGESIZE,stuname,stuno,stusex);
        map.addAttribute("pi",pageInfo);
        map.addAttribute("sname",stuname);
        map.addAttribute("sno",stuno);
        map.addAttribute("ssex",stusex);

        return "Educational/student/list";
    }
    /**
     * 跳转新增页面,查询院系列表
     */
    @RequestMapping(value = "/Educational/student/selectdepts")
    public String getdepts(ModelMap map){
        List<Department> depts = departmentMapperService.findall();
        map.addAttribute("dlist",depts);
        return "/Educational/student/add";
    }

    /**
     * 根据院系id查询专业
     */
    @RequestMapping("/Educational/student/findmajorbyid")
    @ResponseBody
    public List getMajors(int deptid){
        List<Major> majorList = majorMapperService.findbydeptid(deptid);
        return majorList;
    }

    /**
     * 根据专业id查询班级
     */
    @RequestMapping("/Educational/student/findclassid")
    @ResponseBody
    public List fingbymajorid(int mid){

        List<Classes> classesList = classesMapperService.findbimid(mid);
        for (Classes classes : classesList) {
            System.out.println(classes.getClassid()+classes.getClassname());
        }
        return classesList;
    }
    /**
     * 新增学生
     */
    @RequestMapping("/Educational/student/addstudent")
    public String addstudent(Student student){
        student.setRegdate(new Date());
        student.setStustate("正常");
        int i=studentMapperService.insertSelective(student);
        if(i>0){
            return "redirect:/Educational/student/selectall";
        }
        return "redirect:/Educational/student/selectdepts";
    }
    /**
     * 更新学生状态
     */
    @RequestMapping("/Educational/student/updatestate")
    public String updateState(Student student){
        student.setStustate("退学");
        System.out.println(student.getStudentid());
        int i=studentMapperService.updateByPrimaryKeySelective(student);
        System.out.println(i);
        return  "redirect:/Educational/student/selectall";
    }



}
