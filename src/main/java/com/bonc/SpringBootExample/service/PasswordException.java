/*
 * 文件名：PasswordException.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月13日
 */

package com.bonc.SpringBootExample.service;

public class PasswordException extends RuntimeException
{

    public PasswordException()
    {
    }

    public PasswordException(String message)
    {
        super(message);
    }

    public PasswordException(Throwable cause)
    {
        super(cause);
    }

    public PasswordException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PasswordException(String message, Throwable cause, boolean enableSuppression,
                             boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
