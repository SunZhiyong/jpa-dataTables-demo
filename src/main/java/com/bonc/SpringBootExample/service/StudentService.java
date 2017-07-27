/*
 * 文件名：StudentService.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月17日
 */

package com.bonc.SpringBootExample.service;

import java.util.List;
import com.bonc.SpringBootExample.entity.Major;
import com.bonc.SpringBootExample.entity.Student;
import com.bonc.SpringBootExample.util.JsonResult;

public interface StudentService
{
    Boolean addStudent(Student student);
    JsonResult findStudent(int start,int end);
    JsonResult allstudent();
    JsonResult findPartStudent();
    JsonResult findByDepartment(String one,String two);
    JsonResult findByAge(int first,int last);
    JsonResult countByDepartment();
    JsonResult selectScore(String name);
    JsonResult selectAll();
    JsonResult sumScore();
    JsonResult inforOfStudent(String cname1,String cname2);
    List countByMajor();
}
