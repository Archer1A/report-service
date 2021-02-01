package com.vic.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private int id;
    private String password;
    private String name;
}
