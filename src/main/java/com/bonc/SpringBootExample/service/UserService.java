/*
 * 文件名：UserService.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月10日
 */

package com.bonc.SpringBootExample.service;

import com.bonc.SpringBootExample.entity.User;

/**
 * 
 * 用户Service类
 * @author zhiyong
 * @version 2017年7月10日
 * @see UserService
 * @since
 */
public interface UserService
{
    User userLogin(String name, String password)throws UserNotFoundException,PasswordException;
    Boolean adduser(String name,String password,String usertype)throws UserNameException,PasswordException;
}
