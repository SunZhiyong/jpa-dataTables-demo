/*
 * 文件名：AbstractController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月13日
 */

package com.bonc.SpringBootExample.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bonc.SpringBootExample.util.JsonResult;


public class AbstractController
{

    /**
     * 在其他控制器方法执行出现异常时候, 执行
     * 异常处理方法 handleException
     */
    @ExceptionHandler
    @ResponseBody
    public JsonResult handlerException(Exception e) {
        e.printStackTrace();
        return new JsonResult(e);
    }

}
