/*
 * 文件名：ScoreServiceImpl.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月18日
 */

package com.bonc.SpringBootExample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonc.SpringBootExample.dao.ScoreDao;
import com.bonc.SpringBootExample.service.ScoreService;
import com.bonc.SpringBootExample.util.JsonResult;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService
{
    @Autowired
    private ScoreDao scoreDao;
    
    public JsonResult avgScore(){
        return new JsonResult(scoreDao.avgScore());
    }
    
    public JsonResult lowComputerScore(String cname,int grade){
        return new JsonResult(scoreDao.lowComputerScore(cname,grade));
    }
}
