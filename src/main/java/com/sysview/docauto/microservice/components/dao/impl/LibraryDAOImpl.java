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

import com.sysview.docauto.microservice.components.dao.LibraryDAO;
import com.sysview.docauto.microservice.components.models.Library;

@Repository
public class LibraryDAOImpl implements LibraryDAO {
	
	private Logger log = LoggerFactory.getLogger(LibraryDAOImpl.class);

	@Autowired JdbcTemplate jdbcTemplate;
	
	public class LibraryMapper implements RowMapper<Library> {
		public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
			Library library = new Library();
			library.setIdLibrary(rs.getString("BIBLIOTECAID"));
			return library;
		}
	}
	
	private static final String SQL_GET_ALL = "SELECT BIBLIOTECAID FROM BIBLIOTECA ORDER BY BIBLIOTECAID";
	@Override
	public List<Library> getAll() {
		log.info(SQL_GET_ALL);
		return jdbcTemplate.query(SQL_GET_ALL, new LibraryMapper());
	}
	
	
}
