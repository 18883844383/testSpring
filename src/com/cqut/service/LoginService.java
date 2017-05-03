package com.cqut.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.dao.AdminDao;
import com.cqut.entity.Admin;
import com.cqut.exception.AdminCodeException;
import com.cqut.exception.PasswordException;

@Service
public class LoginService implements Serializable {
    @Resource
    private AdminDao adminDao;
    /**
     * 校验管理员账号和密码
     * @param adminCode 账号
     * @param password 密码
     * @return 验证通过时返回管理员对象
     */
    public Admin checkAdminCodeAndPwd(
            String adminCode, String password)
            throws AdminCodeException, PasswordException {
        Admin admin = adminDao.findByCode(adminCode);
        if(admin == null) {
            throw new AdminCodeException("账号错误");
        } else if (!admin.getPassword().equals(password)) {
            throw new PasswordException("密码错误");
        } else {
            return admin;
        }
    }
    
    public List<Admin> findAll() {
        return adminDao.findAll();
    }
}