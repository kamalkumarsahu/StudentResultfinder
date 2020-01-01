package com.srf.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class DataBaseConnectionDao {
	public static Connection con = null;

	private static Logger log = Logger.getLogger(DataBaseConnectionDao.class);

	public DataBaseConnectionDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kumar", "kamal1996");

			log.info("connection is created.");
		} catch (Exception e) {
			log.error("failed to creat conneciton due to :" + e.getMessage());
		}
	
	}

	public Connection getConnection() {
		return con;
	}
}
