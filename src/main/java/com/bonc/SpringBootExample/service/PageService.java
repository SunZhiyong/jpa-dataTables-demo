/*
 * 文件名：PageService.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月19日
 */

package com.bonc.SpringBootExample.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bonc.SpringBootExample.entity.Student;

public interface PageService
{
    Page<Student> findAll(Pageable pageable);
    List<Student> findStudent(int start,int length);
}
