package com.srf.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.srf.beans.StudentDataHold;
import com.srf.beans.StudentResultHold;
import com.srf.dao.AllDataRetriveDao;
import com.srf.dao.DataRetrivalByClassDao;
import com.srf.dao.DataRetriveByRollNoDao;

public class StudentDataCalculation {
	DataRetriveByRollNoDao dataRetrive = null;

	DataRetrivalByClassDao studentByClassDao = null;
	AllDataRetriveDao allData=null;
	private static Logger log = Logger.getLogger(StudentDataCalculation.class);
	public StudentDataCalculation() {
		// TODO Auto-generated constructor stub
		dataRetrive = new DataRetriveByRollNoDao();
		studentByClassDao = new DataRetrivalByClassDao();
		allData=new AllDataRetriveDao();
	}

	public List<StudentResultHold> retriveAllStudent() throws Exception{
		List<StudentResultHold> listStudentResultHold=null;
		log.info("Dataretrivallayer is being called");
		List<StudentDataHold> listStudentDataHold= allData.allDataRetrive();
		log.info("all student data stored in student data array list");
		listStudentResultHold=new ArrayList<StudentResultHold>();
		for(StudentDataHold student:listStudentDataHold){
			StudentResultHold resultHold=AvgCal(student);
			listStudentResultHold.add(resultHold);
		}
		log.info("all student avg calculation done and stored in student result list");
		return listStudentResultHold;

	}

	public List<StudentResultHold> retriveStudentsByClass(int clazz) throws Exception {
		List<StudentResultHold> listStudentResultHold = null;
		log.info("Dataretrivallayer is being called");
		List<StudentDataHold> listStudentDataHold = studentByClassDao.retriveByClazz(clazz);
		log.info(" student data of a class stored in student data array list");
		listStudentResultHold = new ArrayList<StudentResultHold>();
		for (StudentDataHold student : listStudentDataHold) {
			StudentResultHold studenResult = AvgCal(student);
			listStudentResultHold.add(studenResult);
		}
		log.info("student avg of a classcalculation done and stored in student result list");
		return listStudentResultHold;
	}

	public StudentResultHold retriveStudentByRollNo(int rollNo) throws Exception {
		log.info("Dataretrivallayer is being called");
		StudentDataHold student = dataRetrive.retriveByRoll(rollNo);
		log.info(" student data stored in bean object");
		StudentResultHold studentResult = AvgCal(student);
		log.info("avg calculation done in service layer");
		return studentResult;
		
	}

	private StudentResultHold AvgCal(StudentDataHold student) {
		StudentResultHold result = new StudentResultHold();
		int sub1 = student.getSub1();
		int sub2 = student.getSub2();
		int sub3 = student.getSub3();
		float avg = (float) ((sub1 + sub2 + sub3) / 3);
		result.setAvg(avg);
		result.setSdh(student);
		return result;
	}
}
