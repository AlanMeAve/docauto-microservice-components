package com.sysview.docauto.microservice.components.dao.impl;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sysview.docauto.microservice.components.dao.QueryDAO;
import com.sysview.docauto.microservice.components.models.Library;
import com.sysview.docauto.microservice.components.models.Platform;
import com.sysview.docauto.microservice.components.models.Product;
import com.sysview.docauto.microservice.components.models.Query;
import com.sysview.docauto.microservice.components.models.System;
import com.sysview.docauto.microservice.components.util.Util;
import com.sysview.docauto.microservice.components.models.Class;

@Repository
public class QueryDAOImpl implements QueryDAO {

	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired Util util;

	@Override
	public List<System> getSystemsByPlatform(Platform platform) {
		return jdbcTemplate.query("SELECT DISTINCT SISTEMAID AS IDSYSTEM FROM CONSULTA WHERE PLATAFORMAID = ?", new Object[] { platform.getIdPlatform() }, new BeanPropertyRowMapper<>(System.class));
	}

	@Override
	public List<Class> getClasessBySystem(System system) {
		return jdbcTemplate.query("SELECT DISTINCT CLASEID AS IDCLASS FROM CONSULTA WHERE SISTEMAID = ?", new Object[] { system.getIdSystem() }, new BeanPropertyRowMapper<>(Class.class));
	}

	@Override
	public List<Library> getLibrariesByClass(Class clazz) {
		return jdbcTemplate.query("SELECT DISTINCT BIBLIOTECAID AS IDLIBRARY FROM CONSULTA WHERE CLASEID = ?", new Object[] { clazz.getIdClass() }, new BeanPropertyRowMapper<>(Library.class));
	}

	@Override
	public List<Query> getAllFiltered(Query query) {

		StringBuilder sql = new StringBuilder("SELECT DISTINCT PLATAFORMAID, SISTEMAID, CLASEID, BIBLIOTECAID, COMPONENTE FROM CONSULTADETALLE WHERE 1 = 1");

		List<Object> params = new ArrayList<>();

		if (query != null && query.getPlatform() != null && query.getPlatform().getIdPlatform() != null
				&& !query.getPlatform().getIdPlatform().isEmpty()) {
			sql.append(" AND PLATAFORMAID = ? ");
			params.add(query.getPlatform().getIdPlatform());
		}

		if (query != null && query.getSystem() != null && query.getSystem().getIdSystem() != null
				&& !query.getSystem().getIdSystem().isEmpty()) {
			sql.append(" AND SISTEMAID = ? ");
			params.add(query.getSystem().getIdSystem());
		}

		if (query != null && query.getClazz() != null && query.getClazz().getIdClass() != null
				&& !query.getClazz().getIdClass().isEmpty()) {
			sql.append(" AND CLASEID = ? ");
			params.add(query.getClazz().getIdClass());
		}

		if (query != null && query.getLibrary() != null && query.getLibrary().getIdLibrary() != null
				&& !query.getLibrary().getIdLibrary().isEmpty()) {
			sql.append(" AND BIBLIOTECAID = ? ");
			params.add(query.getLibrary().getIdLibrary());
		}

		if (query != null && query.getComponent() != null && !query.getComponent().isEmpty()) {
			sql.append(" AND UPPER(COMPONENTE) LIKE UPPER(?) ");
			params.add(query.getComponent());
		}

		return jdbcTemplate.query(sql.toString(), params.toArray(), new QueryMapper());

	}

	@Override
	public Query getComponentByName(String component) {
		return jdbcTemplate.queryForObject("SELECT DISTINCT COMPONENTE, PLATAFORMAID, SISTEMAID, CLASEID, BIBLIOTECAID FROM CONSULTADETALLE WHERE COMPONENTE = ? AND ROWNUM = 1", new QueryMapper(), component);
	}
	
	@Override
	public List<Query> getComponentDetailByName(String component) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT DISTINCT cd.componente, ");
		sql.append("    cd.productoid, ");
		sql.append("    cd.formatoid,  ");
		sql.append("    cd.bibliotecaid,  ");
		sql.append("    cd.claseid,  ");
		sql.append("    cd.plataformaid,  ");
		sql.append("    cd.sistemaid,  ");
		sql.append("    cp.descripcion  ");
		sql.append("  FROM  ");
		sql.append("    consultadetalle    cd,  ");
		sql.append("    catalogoproductos  cp  ");
		sql.append("  WHERE  ");
		sql.append("    componente = ?  ");
		sql.append("    AND cd.productoid = cp.productoid  ");
		
		return jdbcTemplate.query(sql.toString(), new Object[] { component }, new QueryMapper());
	}

	public class QueryMapper implements RowMapper<Query> {
		public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
			Query query = new Query();
			query.setPlatform(util.hasColumn(rs, "PLATAFORMAID") ? new Platform(rs.getString("PLATAFORMAID")) : new Platform());
			query.setSystem(util.hasColumn(rs, "SISTEMAID") ? new System(rs.getString("SISTEMAID")) : new System()); 
			query.setClazz(util.hasColumn(rs, "CLASEID") ? new Class(rs.getString("CLASEID")) : new Class());
			query.setLibrary(util.hasColumn(rs, "BIBLIOTECAID") ? new Library(rs.getString("BIBLIOTECAID")) : new Library());
			query.setComponent(util.hasColumn(rs, "COMPONENTE") ? rs.getString("COMPONENTE") : null);
			query.setProduct(new Product());
			query.getProduct().setIdProduct(util.hasColumn(rs, "PRODUCTOID") ? rs.getString("PRODUCTOID") : null);
			query.getProduct().setDescription(util.hasColumn(rs, "DESCRIPCION") ? rs.getString("DESCRIPCION") : null);
			query.getProduct().setFormat(util.hasColumn(rs, "FORMATOID") ? rs.getString("FORMATOID") : null);
			return query;
		}
	}
	
	@Override
	public Blob getFileComponent(Query query) {
		String sql = "SELECT DOCTO FROM CONSULTADETALLE WHERE FORMATOID = ? AND PLATAFORMAID = ? AND CLASEID = ? AND BIBLIOTECAID = ? AND SISTEMAID = ? AND COMPONENTE = ? AND PRODUCTOID = ?";
		Object[] params = new Object[] { query.getProduct().getFormat(), query.getPlatform()
				.getIdPlatform(), query.getClazz().getIdClass(), query.getLibrary().getIdLibrary(), query.getSystem().getIdSystem(), query.getComponent(), query.getProduct().getIdProduct()};
		return jdbcTemplate.queryForObject(sql, Blob.class, params);
	}
	

}
