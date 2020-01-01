package com.rsf.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.srf.beans.StudentDataHold;
import com.srf.dao.DataRetriveByRollNoDao;
import com.srf.exception.NullPointException;

public class DataRetriveByRollTest {
	DataRetriveByRollNoDao dataRetrive = null;

	@Before
	public void init() {
		dataRetrive = new DataRetriveByRollNoDao();
	}

	// student present in db
	@Test
	public void checkRetrivedData() throws Exception {
		StudentDataHold student1 = dataRetrive.retriveByRoll(115);
		String fName = student1.getfName();
		Assert.assertEquals("kamal", fName);
	}
	
	// student not present in db
	@Test(expected=NullPointException.class)
	public void checkRetrivedDataException() throws NullPointException {
		dataRetrive.retriveByRoll(10);
	}
}
