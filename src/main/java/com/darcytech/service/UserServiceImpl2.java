package com.darcytech.service;

import com.darcytech.model.User;

/**
 * Created by GXL on 2016/7/26.
 */

@Deprecated
public class UserServiceImpl2 implements UserService {
    @Override
    public User getUser() {
        System.out.println("实现2");
        return null;
    }

    @Override
    public User save() {
        return null;
    }
}
