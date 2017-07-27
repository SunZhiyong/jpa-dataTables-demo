/*
 * 文件名：ScoreService.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月18日
 */

package com.bonc.SpringBootExample.service;

import com.bonc.SpringBootExample.util.JsonResult;

public interface ScoreService
{
    JsonResult avgScore();
    JsonResult lowComputerScore(String cname,int grade);
}
