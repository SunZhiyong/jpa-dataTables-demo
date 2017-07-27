/*
 * 文件名：StudentPageDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月19日
 */

package com.bonc.SpringBootExample.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bonc.SpringBootExample.entity.Student;

public interface StudentPageDao extends PagingAndSortingRepository<Student, Long>
{
    Page<Student> findAll(Pageable pageable);
    
    @Query(value="SELECT * FROM student LIMIT ?,?",nativeQuery=true)
    List<Student>findStudent(int start,int length);
}
