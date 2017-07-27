/*
 * 文件名：UserNotFoundException.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月13日
 */

package com.bonc.SpringBootExample.service;

public class UserNotFoundException extends RuntimeException
{

    public UserNotFoundException()
    {
    }

    public UserNotFoundException(String arg0)
    {
        super(arg0);
    }

    public UserNotFoundException(Throwable arg0)
    {
        super(arg0);
    }

    public UserNotFoundException(String arg0, Throwable arg1)
    {
        super(arg0, arg1);
    }

    public UserNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
    {
        super(arg0, arg1, arg2, arg3);
    }

}
