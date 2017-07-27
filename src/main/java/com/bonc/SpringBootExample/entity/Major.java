/*
 * 文件名：major.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月27日
 */

package com.bonc.SpringBootExample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Major
{   
    @Id
    @Column( name= "id",unique = true)
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long   id;
    private String department;
    private int    number;
    
    public Major()
    {
    }
    
    
    public Major(String department, int number)
    {
        super();
        this.department = department;
        this.number = number;
    }


    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }
}
