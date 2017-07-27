/*
 * 文件名：UserDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月10日
 */

package com.bonc.SpringBootExample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bonc.SpringBootExample.entity.User;

@Transactional
public interface UserDao extends JpaRepository<User, Long>
{
    User findUserByUserName(String userName);
    User save(User user);
}
