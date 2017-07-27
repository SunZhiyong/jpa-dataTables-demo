/*
 * 文件名：ScoreDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月17日
 */

package com.bonc.SpringBootExample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bonc.SpringBootExample.entity.Score;

@Transactional
public interface ScoreDao extends JpaRepository<Score, Long>
{ 
    @Query(value="select cname,AVG(grage) FROM score GROUP BY cname",nativeQuery=true)
    List avgScore();
    
    @Query(value="SELECT * FROM student WHERE stu_id IN (SELECT stu_id FROM score WHERE cname=? and grage<?);",nativeQuery=true)
    List lowComputerScore(String cname,int grade);
    
}
