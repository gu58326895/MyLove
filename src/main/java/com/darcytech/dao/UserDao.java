package com.darcytech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darcytech.model.User;
import com.darcytech.model.VisitLog;

/**
 * Created by guxiaoli on 2017/2/10.
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
