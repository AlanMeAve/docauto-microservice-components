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

import com.sysview.docauto.microservice.components.dao.SystemDAO;
import com.sysview.docauto.microservice.components.models.System;

@Repository
public class SystemDAOImpl implements SystemDAO {
	
	private Logger log = LoggerFactory.getLogger(SystemDAOImpl.class);

	@Autowired JdbcTemplate jdbcTemplate;
	
	public class SystemMapper implements RowMapper<System> {
		public System mapRow(ResultSet rs, int rowNum) throws SQLException {
			System system = new System();
			system.setIdSystem(rs.getString("SISTEMAID"));
			return system;
		}
	}
	
	private static final String SQL_GET_ALL = "SELECT SISTEMAID FROM SISTEMA ORDER BY SISTEMAID";
	@Override
	public List<System> getAll() {
		log.info(SQL_GET_ALL);
		return jdbcTemplate.query(SQL_GET_ALL, new SystemMapper());
	}
	
	
}
