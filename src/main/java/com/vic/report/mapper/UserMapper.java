package com.vic.report.mapper;

import com.vic.report.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUsers(String userName, String password);

}
