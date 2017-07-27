/*
 * 文件名：PageServiceImpl.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月19日
 */

package com.bonc.SpringBootExample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bonc.SpringBootExample.dao.StudentPageDao;
import com.bonc.SpringBootExample.entity.Student;
import com.bonc.SpringBootExample.service.PageService;

@Service("pageService")
public class PageServiceImpl implements PageService
{
    
    @Autowired
    private StudentPageDao studentPageDao;
    
    @Override
    public Page<Student> findAll(Pageable pageable){
        return studentPageDao.findAll(pageable);
    }
    
    @Override
    public List<Student>findStudent(int start,int length) {
        return studentPageDao.findStudent(start, length);
    }
}
