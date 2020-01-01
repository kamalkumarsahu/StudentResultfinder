package com.srf.test.service;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.srf.beans.StudentResultHold;
import com.srf.service.StudentDataCalculation;

public class AvgCalculation {
	StudentDataCalculation cal=null;
	@Before
	public void  init(){
		cal=new StudentDataCalculation();
	}
	@Test
	public void avgCal()throws Exception{
		
		StudentResultHold res=cal.retriveStudentByRollNo(111);
		float res1=res.getAvg();
		Assert.assertEquals(50.0, res1, 0.5);
		
	}
}
