/*
 * 文件名：UserNameException.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月13日
 */

package com.bonc.SpringBootExample.service;

public class UserNameException extends RuntimeException
{

    public UserNameException()
    {
    }

    public UserNameException(String arg0)
    {
        super(arg0);
    }

    public UserNameException(Throwable arg0)
    {
        super(arg0);
    }

    public UserNameException(String arg0, Throwable arg1)
    {
        super(arg0, arg1);
    }

    public UserNameException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
    {
        super(arg0, arg1, arg2, arg3);
    }

}
