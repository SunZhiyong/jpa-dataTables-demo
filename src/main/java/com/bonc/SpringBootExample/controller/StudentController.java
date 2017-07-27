/*
 * 文件名：StudentController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月17日
 */

package com.bonc.SpringBootExample.controller;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bonc.SpringBootExample.entity.Major;
import com.bonc.SpringBootExample.entity.Student;
import com.bonc.SpringBootExample.service.StudentService;
import com.bonc.SpringBootExample.util.JsonResult;

@Controller
public class StudentController extends AbstractController
{
    
    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;
    
    @RequestMapping("/addStudent")
    @ResponseBody
    public JsonResult login(@RequestParam("StuName") String stuname,@RequestParam("StuSex") String stusex,
                            @RequestParam("Year") int year,@RequestParam("Department") String department,
                            @RequestParam("Address") String address){
        Date dates =new Date();
        dates.setYear(year-1900);
        Student student = new Student();
        student.setStuName(stuname);
        student.setStuSex(stusex);
        student.setYear(dates);
        student.setDepartment(department);
        student.setAddress(address);
        Boolean results = studentService.addStudent(student);
       return new JsonResult(results);
    }
    
    @RequestMapping("/selectStudent")
    @ResponseBody
    public JsonResult select(@RequestParam("start") int start,@RequestParam("end") int end){
        return studentService.findStudent(start, end);
    }
    
    @RequestMapping("/allStudent")
    @ResponseBody
    public JsonResult select(){
        return studentService.allstudent();
    }
    
    @RequestMapping("/partStudent")
    @ResponseBody
    public JsonResult partStudent(){
        return studentService.findPartStudent();
    }
    
    @RequestMapping("/department")
    @ResponseBody
    public JsonResult department(@RequestParam("one") String one , @RequestParam("two") String two){
       return studentService.findByDepartment(one, two);
    } 
    
    @RequestMapping("/age")
    @ResponseBody
    public JsonResult age(@RequestParam("first") int first , @RequestParam("last") int last){
       return studentService.findByAge(first, last);
    } 
    
    @RequestMapping("/countByDepartment")
    @ResponseBody
    public JsonResult age(){
       return studentService.countByDepartment();
    } 
    
    @RequestMapping("/score")
    @ResponseBody
    public JsonResult score(@RequestParam("name") String name){
       return studentService.selectScore(name);
    } 
    
    @RequestMapping("/selectAll")
    @ResponseBody
    public JsonResult selectAll(){
       return studentService.selectAll();
    } 
    
    @RequestMapping("/sumScore")
    @ResponseBody
    public JsonResult sumScore(){
       return studentService.sumScore();
    } 
    
    @RequestMapping("/inforOfStudent")
    @ResponseBody
    public JsonResult inforOfStudent(@RequestParam("cname1") String cname1,@RequestParam("cname2") String cname2){
       return studentService.inforOfStudent( cname1,cname2);
    } 
    
    @RequestMapping("/countByMajor")
    @ResponseBody
    public JSON countByMajor(){
        Map<String,Object> map = new HashMap<>();
        List  results = studentService.countByMajor();
        return (JSON)JSON.toJSON(results);
    }
}
