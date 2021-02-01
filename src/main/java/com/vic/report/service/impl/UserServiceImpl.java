package com.vic.report.service.impl;

import com.vic.report.mapper.UserMapper;
import com.vic.report.model.User;
import com.vic.report.service.UserService;
import org.glassfish.jersey.internal.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String login(String name, String password) {
        List<User> users = userMapper.getUsers(name, password);
        if (users.size() != 1) {
            return "";
        }else {
            return Base64.encodeAsString(name + ":" + password);
        }
    }

    @Override
    public boolean checkToken(String token) {
        String s = Base64.decodeAsString(token);
        String[] msg = s.split( ":");
        if (msg.length != 2) {
            return false;
        }
        String login = login(msg[0], msg[1]);
        return !"".equals(login);
    }
}
