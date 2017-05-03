package com.cqut.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.cqut.entity.Admin;
@Repository
public class JdbcAdminDao implements AdminDao, Serializable{

	@Resource DataSource ds;
	
	public Admin findByCode(String adminCode) {
		
		if (adminCode == null)
            return null;
		Connection conn = null;
		try {
            conn = ds.getConnection();
            String sql = "select * from admin_info where admin_code=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, adminCode);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setAdminCode(rs.getString("admin_code"));
                admin.setPassword(rs.getString("password"));
                admin.setName(rs.getString("name"));
                admin.setTelephone(rs.getString("telephone"));
                admin.setEmail(rs.getString("email"));
                
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("鏍规嵁缂栫爜鏌ヨ绠＄悊鍛樺け璐�", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }

	public List<Admin> findAll() {
		List<Admin> list = new ArrayList<Admin>();
        Connection conn = null;
        try{
        	conn = ds.getConnection();
            String sql = "select * from admin_info order";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setAdminCode(rs.getString("admin_code"));
                admin.setPassword(rs.getString("password"));
                admin.setName(rs.getString("name"));
                admin.setTelephone(rs.getString("telephone"));
                admin.setEmail(rs.getString("email"));
                list.add(admin);
                
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("鏌ヨ澶辫触", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
	}
}


