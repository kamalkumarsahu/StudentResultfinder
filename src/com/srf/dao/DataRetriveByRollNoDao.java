package com.srf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.srf.beans.StudentDataHold;
import com.srf.exception.NullPointException;

public class DataRetriveByRollNoDao {
	PreparedStatement ps = null;
	Connection con = null;
	public static final String qry = "SELECT * FROM STUDENT WHERE ROLLNO=?";
	private static Logger log = Logger.getLogger(DataRetriveByRollNoDao.class);
	public StudentDataHold retriveByRoll(int rollNo) throws NullPointException {
		con = new DataBaseConnectionDao().getConnection();
		//log.info("Connection object is being Created");
		StudentDataHold student = new StudentDataHold();
		try {
			ps = con.prepareStatement(qry);
			ps.setInt(1, rollNo);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				// set all data in student form rs
				student.setrNo(rs.getInt("rollno"));
				student.setfName(rs.getString("firstname"));
				student.setlName(rs.getString("lastname"));
				student.setAddress(rs.getString("address"));
				student.setClazz(rs.getInt("class"));
				student.setSub1(rs.getInt("sub1"));
				student.setSub2(rs.getInt("sub2"));
				student.setSub3(rs.getInt("sub3"));
			} else {
				log.trace("student not found in db exception may raised.");
				throw new NullPointException("Student not found.,...");
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			student = null;
		}
		return student;
	}
}
