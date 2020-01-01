package com.srf.contoller;

import java.util.List;

import org.apache.log4j.Logger;

import com.srf.beans.StudentDataHold;
import com.srf.beans.StudentResultHold;
import com.srf.service.StudentDataCalculation;

public class AssignResultControler {
	// service
	StudentDataCalculation calculate = null;

	public AssignResultControler() {
		// TODO Auto-generated constructor stub
		calculate = new StudentDataCalculation();
	}
	private static Logger log = Logger.getLogger(AssignResultControler.class);
	public List<StudentResultHold> findAllResults(){
		List<StudentResultHold> listStudentRecordHold=null;
		log.info("The service Layer is being called");
		try{
			listStudentRecordHold=calculate.retriveAllStudent();
			log.info("calculation of all student avg mark  done in service layer");
			for(StudentResultHold studentRecord:listStudentRecordHold){
				studentRecord=setResult(studentRecord);
			}
			log.info("all student result stored weather pass/fail in student result list");
		}
		catch(Exception e){
			log.error(e.getMessage());
			listStudentRecordHold=null;
		}
		return listStudentRecordHold;
	}
	/**
	 * 
	 * @param clazz
	 * @return list
	 */
	public List<StudentResultHold> findStudentByClass(int clazz) {
		List<StudentResultHold> listStudentResult =null;
		log.info("The service Layer is being called");
		try {
		 listStudentResult = calculate.retriveStudentsByClass(clazz);
		 log.info("calculation of student avg mark of a class done in service layer");
			for (StudentResultHold studentResult : listStudentResult) {
				studentResult = setResult(studentResult);
			}
			log.info(" student result of a class stored weather pass/fail in student result list");
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		
			listStudentResult=null;
		}
		return listStudentResult;
	}

	public StudentResultHold findResult(int rollNo) {
		StudentResultHold result = null;
		log.info("The service Layer is being called");
		try {
			// StudentResultHold result=calculate.AvgCal(rollNo);
			result = calculate.retriveStudentByRollNo(rollNo);
			log.info("avg mark calculation done in service layer");
			// set the result whether student have to pass or fail.
			result = setResult(result);
			log.info("student result stored weather pass/fail in student result list");
		} catch (Exception e) {
			log.error(e.getMessage());
			result=null;
		}
		return result;
	}

	public StudentResultHold setResult(StudentResultHold result) {
		float avg = result.getAvg();
		StudentDataHold data = result.getSdh();
		int clazz = data.getClazz();

		switch (clazz) {
		case 10:
			if (avg > 50)
				result.setRes("pass");
			else
				result.setRes("fail");
			return result;
		case 9:
			if (avg > 45)
				result.setRes("pass");
			else
				result.setRes("fail");
			return result;
		case 8:
			if (avg > 40)
				result.setRes("pass");
			else
				result.setRes("fail");
			return result;
		case 7:
			if (avg > 35)
				result.setRes("pass");
			else
				result.setRes("fail");
			return result;
		case 6:
			if (avg > 30)
				result.setRes("pass");
			else
				result.setRes("fail");
			return result;
		case 5:
			if (avg > 25)
				result.setRes("pass");
			else
				result.setRes("fail");
			break;
		default:
			if (avg > 25)
				result.setRes("pass");
			else
				result.setRes("fail");
		}
		return result;
	}

}
