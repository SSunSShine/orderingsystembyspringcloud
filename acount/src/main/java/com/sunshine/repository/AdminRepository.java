package com.sunshine.repository;

import com.sunshine.entity.Admin;

public interface AdminRepository {
    public Admin login(String username,String password);
}
