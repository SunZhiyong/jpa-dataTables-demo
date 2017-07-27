/*
 * 文件名：UserServiceImpl.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月10日
 */

package com.bonc.SpringBootExample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.ElementCSSInlineStyle;

import com.bonc.SpringBootExample.dao.UserDao;
import com.bonc.SpringBootExample.entity.User;
import com.bonc.SpringBootExample.service.PasswordException;
import com.bonc.SpringBootExample.service.UserNameException;
import com.bonc.SpringBootExample.service.UserNotFoundException;
import com.bonc.SpringBootExample.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    UserDao userDao;
    
    public User userLogin(String name, String password)throws UserNotFoundException,PasswordException{
        if(name==null || name.trim().isEmpty()){
            throw new UserNotFoundException("用户名不得为空！");
        }
        if(password==null || password.trim().isEmpty()){
            throw new PasswordException("密码不得为空！");
        }
        User user = userDao.findUserByUserName(name.trim());
        if(user == null){
            throw new UserNotFoundException("该用户未注册！");
        }
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new PasswordException("密码错误!");
        
    }

    public Boolean adduser(String name,String password,String usertype)throws UserNameException,PasswordException{
      //检查userName, 用户名不能重复
        if(name==null || name.trim().isEmpty()){
            throw new UserNameException("用户名不得为空！");
        }
        User one = userDao.findUserByUserName(name.trim());
        if(one!=null){
            throw new UserNameException("该用户已注册！");
        }
        //检查用户密码
        if(password==null || password.trim().isEmpty()){
            throw new PasswordException("密码不得为空!");
        }
        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        user.setUserType(usertype);
        User users = userDao.save(user);
        if(users!=null){
        return true;
        }
        else {
            throw new RuntimeException("用户注册失败!");
        }
    }
}

