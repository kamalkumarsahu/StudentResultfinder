package com.srf.test.controler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.srf.beans.StudentResultHold;
import com.srf.contoller.AssignResultControler;

public class ResultCheck {
	AssignResultControler assResult=null;
	@Before
	public void init(){
		assResult=new AssignResultControler();
	}
	@Test
	public void ResCheck(){
		StudentResultHold res=assResult.findResult(111);
		String result=res.getRes();
		Assert.assertEquals("pass", result);
	}
}
