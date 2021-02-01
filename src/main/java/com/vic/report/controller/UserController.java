package com.vic.report.controller;

import com.vic.report.model.ResponseResult;
import com.vic.report.model.User;
import com.vic.report.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        String token = userService.login(user.getName(), user.getPassword());
        if ("".equals(token)) {
            return ResponseResult.failString("密码错误！");
        }
        return ResponseResult.successString(token);
    }
}
