/*
 * 文件名：StudentServiceImpl.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月17日
 */

package com.bonc.SpringBootExample.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonc.SpringBootExample.dao.StudentDao;
import com.bonc.SpringBootExample.entity.Major;
import com.bonc.SpringBootExample.entity.Student;
import com.bonc.SpringBootExample.service.StudentService;
import com.bonc.SpringBootExample.util.JsonResult;

@Service("studentService")
public class StudentServiceImpl implements StudentService
{
    @Autowired
    StudentDao studentDao;
    public Boolean addStudent(Student student)
    {
        Boolean results = false;
        Student one = studentDao.save(student);
        if(one !=null){
            results = true;
        }
        else{
            throw new RuntimeException("学生注册失败!");
        }
        return results;
    }
    
    public JsonResult findStudent(int start,int end){
        return new JsonResult(studentDao.findStudent(start, end));
    }
    
    public JsonResult allstudent(){
        return new JsonResult(studentDao.findAll());
    }
    
    public JsonResult findPartStudent(){
        return new JsonResult(studentDao.findPartStudent()); 
    }
    
    public JsonResult findByDepartment(String one,String two){
        return new JsonResult(studentDao.findStudentByDepartment(one, two));
    }
    
    public JsonResult findByAge(int first,int last){
        return new JsonResult(studentDao.findStudentByAge(first, last));
    }
    
    public JsonResult countByDepartment(){
        return new JsonResult(studentDao.countByDepartment());
    }
    
    public JsonResult selectScore(String name){
        return new JsonResult(studentDao.selectScore(name));
    }
    
    public JsonResult selectAll(){
        return new JsonResult(studentDao.selectAll());
    }
    
    public JsonResult sumScore(){
        return new JsonResult(studentDao.sumScore());
    }
    
    public JsonResult inforOfStudent(String cname1,String cname2){
        return new JsonResult(studentDao.inforOfStudent(cname1,cname2));
    }
    
    public List countByMajor() {
        return studentDao.countByMajor();
    }
}
