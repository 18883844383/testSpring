package com.cqut.dao;

import java.util.List;

import com.cqut.entity.Admin;

public interface AdminDao {
    
    Admin findByCode(String adminCode);
    List<Admin>findAll();
}
