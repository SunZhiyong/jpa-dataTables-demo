/*
 * 文件名：DataTable.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月26日
 */

package com.bonc.SpringBootExample.dao;

import java.util.List;

public class DataTable<T>
{
    private List<T> aaData;//数据
    private int iTotalDisplayRecords;//得到的记录数
    private int iTotalRecords;//数据库中记录数
    private int sEcho; //请求服务器端次数 
}
