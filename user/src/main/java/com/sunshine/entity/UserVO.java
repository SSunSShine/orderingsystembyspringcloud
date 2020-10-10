package com.sunshine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserVO {
    private int code;
    private String msg;
    private int count;
    private List<User> data;
}
