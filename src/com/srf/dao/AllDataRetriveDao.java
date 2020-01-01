package com.srf.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.srf.beans.StudentDataHold;
import com.srf.exception.NullPointException;

public class AllDataRetriveDao {
	private Statement st = null;
	private Connection con = null;
	private static final String qry = "SELECT * FROM STUDENT";

	public AllDataRetriveDao() {
		con = new DataBaseConnectionDao().getConnection();
	}

	public List<StudentDataHold> studentList = null;
	private static Logger log = Logger.getLogger(AllDataRetriveDao.class);
	public List<StudentDataHold> allDataRetrive() throws NullPointException {

		
		try {
			st = con.createStatement();
			//log.info("Connection object created");
			ResultSet rs = st.executeQuery(qry);
			studentList = new ArrayList<StudentDataHold>();
			while (rs.next()) {
				StudentDataHold student = new StudentDataHold();
				// set all data in student form rs
				student.setrNo(rs.getInt("rollno"));
				student.setfName(rs.getString("firstname"));
				student.setlName(rs.getString("lastname"));
				student.setAddress(rs.getString("address"));
				student.setClazz(rs.getInt("class"));
				student.setSub1(rs.getInt("sub1"));
				student.setSub2(rs.getInt("sub2"));
				student.setSub3(rs.getInt("sub3"));
				studentList.add(student);
			}
			
		} catch (SQLException e) {
			 log.error(e.getMessage());
			e.printStackTrace();
			studentList = null;
		}
		return studentList;
	}
}


