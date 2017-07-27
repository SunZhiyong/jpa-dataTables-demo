/*
 * 文件名：UserController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月10日
 */

package com.bonc.SpringBootExample.controller;

import javax.print.attribute.standard.RequestingUserName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bonc.SpringBootExample.entity.User;
import com.bonc.SpringBootExample.service.PasswordException;
import com.bonc.SpringBootExample.service.UserNameException;
import com.bonc.SpringBootExample.service.UserNotFoundException;
import com.bonc.SpringBootExample.service.UserService;
import com.bonc.SpringBootExample.util.JsonResult;



@Controller
public class UserController extends AbstractController
{
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    
    @RequestMapping("/user")
    @ResponseBody
    public JsonResult login(@RequestParam("username") String username,@RequestParam("password") String password){
       User user = userService.userLogin(username, password);
       return new JsonResult(user);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public JsonResult handleUserNotFound(UserNotFoundException e){
        e.printStackTrace();
        return new JsonResult(2, e);//state = 2
    }
    
    @ExceptionHandler(PasswordException.class)
    @ResponseBody
    public JsonResult handlePassword(PasswordException e){
        e.printStackTrace();
        return new JsonResult(3, e);//state = 3
    }
    
    @RequestMapping("/index")
    public String index(){
        return "welcome/index";
    }
    
    @RequestMapping("/table")
    public String table(){
        return "welcome/table";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "welcome/demo";
    }
    
    @RequestMapping("/regist")
    @ResponseBody
    public JsonResult login(@RequestParam("username") String username,@RequestParam("password") String password,
                            @RequestParam("usertype") String usertype){
       Boolean results = userService.adduser(username, password, usertype);
       return new JsonResult(results);
    }
    
    @ExceptionHandler(UserNameException.class)
    @ResponseBody
    public JsonResult handleUserName(UserNameException e){
        e.printStackTrace();
        return new JsonResult(4, e);//state = 4
    }
    
    @RequestMapping("/href")
    public String regist(){
        return "welcome/regist";
    }
}
