package com.vic.report.service;

public interface UserService {
    String login(String name, String password);

    boolean checkToken(String token);
}
