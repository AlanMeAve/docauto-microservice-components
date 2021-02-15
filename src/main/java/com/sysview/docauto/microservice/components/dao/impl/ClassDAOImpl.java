package com.sysview.docauto.microservice.components.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sysview.docauto.microservice.components.dao.ClassDAO;
import com.sysview.docauto.microservice.components.models.Class;

@Repository
public class ClassDAOImpl implements ClassDAO {
	
	private Logger log = LoggerFactory.getLogger(ClassDAOImpl.class);

	@Autowired JdbcTemplate jdbcTemplate;
	
	public class ClassMapper implements RowMapper<Class> {
		public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
			Class clazz = new Class();
			clazz.setIdClass(rs.getString("CLASEID"));
			return clazz;
		}
	}
	
	private static final String SQL_GET_ALL = "SELECT CLASEID FROM CLASE ORDER BY CLASEID";
	@Override
	public List<Class> getAll() {
		log.info(SQL_GET_ALL);
		return jdbcTemplate.query(SQL_GET_ALL, new ClassMapper());
	}
	
	
}
