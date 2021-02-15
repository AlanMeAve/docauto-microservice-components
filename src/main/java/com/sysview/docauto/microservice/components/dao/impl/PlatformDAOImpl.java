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

import com.sysview.docauto.microservice.components.dao.PlatformDAO;
import com.sysview.docauto.microservice.components.models.Platform;

@Repository
public class PlatformDAOImpl implements PlatformDAO {
	
	private Logger log = LoggerFactory.getLogger(PlatformDAOImpl.class);

	@Autowired JdbcTemplate jdbcTemplate;
	
	public class PlatformMapper implements RowMapper<Platform> {
		public Platform mapRow(ResultSet rs, int rowNum) throws SQLException {
			Platform platform = new Platform();
			platform.setIdPlatform(rs.getString("PLATAFORMAID"));
			return platform;
		}
	}
	
	private static final String SQL_GET_ALL = "SELECT PLATAFORMAID FROM PLATAFORMA ORDER BY PLATAFORMAID";
	@Override
	public List<Platform> getAll() {
		log.info(SQL_GET_ALL);
		return jdbcTemplate.query(SQL_GET_ALL, new PlatformMapper());
	}
	
	
}
