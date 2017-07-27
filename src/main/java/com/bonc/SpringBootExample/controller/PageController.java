/*
  * 文件名：PageController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月19日
 */

package com.bonc.SpringBootExample.controller;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bonc.SpringBootExample.entity.Student;
import com.bonc.SpringBootExample.service.PageService;
import com.bonc.SpringBootExample.util.JsonResult;

@Controller
public class PageController extends AbstractController
{
    @Autowired
    @Qualifier("pageService")
    private PageService pageService;
    
    @RequestMapping("/pageone")
    @ResponseBody
    public Object pageone(@RequestParam("start") Integer page,
                              @RequestParam("length") Integer pagesize){
        PageRequest pages = new PageRequest(page/pagesize, pagesize);
        Page<Student> studentList = pageService.findAll(pages);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("recordsTotal", studentList.getTotalElements());
        resultMap.put("recordsFiltered", studentList.getTotalElements());
        resultMap.put("data", studentList.getContent());
        return JSON.toJSON(resultMap);
    }
    
    @RequestMapping("/page")
    @ResponseBody
    public JsonResult page(@RequestParam("start") Integer start,
                           @RequestParam("length") Integer length){
        return new JsonResult(pageService.findStudent(start, length));
    }

}
