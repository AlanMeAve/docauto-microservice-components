package com.sysview.docauto.microservice.components.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class Util {

	private Util() {}

	public boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		for (int x = 1; x <= columns; x++) {
			if (columnName.equals(rsmd.getColumnName(x))) {
				return true;
			}
		}
		return false;
	}

}
