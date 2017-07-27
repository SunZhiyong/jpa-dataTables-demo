/*
 * 文件名：User.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月10日
 */

package com.bonc.SpringBootExample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * User实体类
 * @author zhiyong
 * @version 2017年7月10日
 * @see User
 * @since
 */
@Entity
public class User
{
    /**
     * 用户ID:userId
     */
    @Id
    @Column( unique = true)
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long userId;
    
    /**
     * 用户名
     */
    private String userName;
    
    /**
     * 用户密码
     */
    private String password;
    
    /**
     * 用户类型
     */
    private String userType;
    
    /**
     * 无参构造方法
     */
    public User(){
    }
    
    /**
     * 构造方法
     * @param userId
     * @param userName
     * @param password
     * @param userType
     */
    public User(Long userId, String userName, String password, String userType)
    {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }
}
