package com.sunshine.repository;

import com.sunshine.entity.User;

public interface UserRepository {
    public User login(String username,String password);
}
