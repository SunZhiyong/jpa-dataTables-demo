/*
 * 文件名：StudentDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月17日
 */

package com.bonc.SpringBootExample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bonc.SpringBootExample.entity.Major;
import com.bonc.SpringBootExample.entity.Student;

@Transactional
public interface StudentDao extends JpaRepository<Student, Long>
{
    @Query(value="SELECT * FROM student LIMIT ?,?",nativeQuery=true)
    List<Student>findStudent(int start,int end);
    
    @Query(value="SELECT stu_id,stu_name,department FROM student;",nativeQuery=true)
    List findPartStudent();
    
    @Query(value="select * from student where department in(?,?)",nativeQuery=true)
    List<Student>findStudentByDepartment(String depart1,String depart2);
    
    @Query(value="select stu_id,stu_name,stu_sex,2017-year(year) as stu_age,department,address from student "+
    "where 2017-year(year)>=? and 2017-year(year)<=?", nativeQuery=true)
    List findStudentByAge(int first,int last);
    
    @Query(value="select department,count(stu_id) from student group by department",nativeQuery=true)
    List countByDepartment();
    
    @Query(value="SELECT cname, grage FROM score WHERE stu_id=(SELECT stu_id FROM student WHERE stu_name=?);",nativeQuery=true)
    List selectScore(String name);
    
    @Query(value="SELECT student.stu_id,stu_name,stu_sex,year(year),department,address,cname,grage FROM student,score "+
    "WHERE student.stu_id=score.stu_id;",nativeQuery=true)
    List selectAll();
    
    @Query(value="SELECT student.stu_id,stu_name,SUM(grage) FROM student,score WHERE student.stu_id=score.stu_id "+
    "GROUP BY student.stu_id",nativeQuery=true)
    List sumScore();
    
   @Query(value="SELECT *  FROM student WHERE stu_id =ANY ( SELECT stu_id FROM score WHERE stu_id IN ( "+
   "SELECT stu_id FROM score WHERE cname=?) AND cname=? );",nativeQuery=true)
   List inforOfStudent(String cname1,String cname2);
   
   @Query(value="select department,count(*) as number from student group by department",nativeQuery=true)
   List countByMajor();
}
