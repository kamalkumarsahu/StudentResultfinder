package com.rsf.dao.test;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.srf.dao.DataBaseConnectionDao;

public class ConnectionTestDao {
	Connection con = null;
	@Before
	public void init() {
		con = new DataBaseConnectionDao().getConnection();
	}
	@Test
	public void checkConnection() {
		Assert.assertNotNull(con);
	}
}
