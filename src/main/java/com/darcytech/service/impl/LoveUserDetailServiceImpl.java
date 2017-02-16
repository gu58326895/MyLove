package com.darcytech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.darcytech.dao.UserDao;
import com.darcytech.model.User;

/**
 * Created by guxiaoli on 2017/2/10.
 */

@Service("loveUserDetailService")
public class LoveUserDetailServiceImpl implements UserDetailsService {


    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
