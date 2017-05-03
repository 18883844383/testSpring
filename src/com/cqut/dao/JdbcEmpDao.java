package com.cqut.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cqut.entity.Emp;
@Repository
public class JdbcEmpDao implements EmpDao{

	@Resource
    private JdbcTemplate jdbcTemplate;
	
	public List<Emp> findAll() {
		String sql = "select * from t_emp";
        return jdbcTemplate.query(sql, new EmpRowMapper());
	}

	public Emp findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	public void update(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	class EmpRowMapper implements RowMapper<Emp>{

		public Emp mapRow(ResultSet rs, int index) throws SQLException {
			Emp e = new Emp();
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setSalary(rs.getDouble("salary"));
          
            return e;
		}
		
	}

}
