package com.cqut.dao;

import java.util.List;

import com.cqut.entity.Emp;

public interface EmpDao {
    List<Emp> findAll();
    Emp findById(int id);
    void save(Emp emp);
    void update(Emp emp);
    void delete(int id);
}
