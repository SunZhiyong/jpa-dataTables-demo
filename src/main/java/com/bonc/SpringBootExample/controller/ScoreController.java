/*
 * 文件名：ScoreController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月18日
 */

package com.bonc.SpringBootExample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bonc.SpringBootExample.service.ScoreService;
import com.bonc.SpringBootExample.util.JsonResult;


@Controller
public class ScoreController extends AbstractController
{
    @Autowired
    @Qualifier("scoreService")
    private ScoreService scoreService;
    
    @RequestMapping("/avgScore")
    @ResponseBody
    public JsonResult avgScore(){
       return scoreService.avgScore();
    } 
   
    @RequestMapping("/lowComputerScore")
    @ResponseBody
    public JsonResult lowComputerScore(@RequestParam("cname") String cname,@RequestParam("grade") int grade){
       return scoreService.lowComputerScore(cname,grade);
    } 
}
