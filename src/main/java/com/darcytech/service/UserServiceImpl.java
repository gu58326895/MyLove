package com.darcytech.service;

import com.darcytech.model.User;

/**
 * Created by GXL on 2016/7/26.
 */
public class UserServiceImpl implements UserService ,UserService2{
    @Override
    public User getUser() {
        System.out.println("实现1");
        return null;
    }

    @Override
    public User save() {
        return null;
    }

    @Override
    public void deleteUser() {

    }
}
