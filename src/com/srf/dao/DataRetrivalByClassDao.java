package com.srf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.srf.beans.StudentDataHold;
import com.srf.exception.NullPointException;

public class DataRetrivalByClassDao {
	private PreparedStatement ps = null;
	private Connection con = null;
	private static final String qry = "SELECT * FROM STUDENT WHERE CLASS=?";
	private static Logger log = Logger.getLogger(DataRetrivalByClassDao.class);
	public DataRetrivalByClassDao() {
		con = new DataBaseConnectionDao().getConnection();
		//log.info("Connection object is being Created");
	}

	public List<StudentDataHold> studentList = null;

	public List<StudentDataHold> retriveByClazz(int clazz) throws NullPointException {

		
		try {
			ps = con.prepareStatement(qry);
			ps.setInt(1, clazz);
			ResultSet rs = ps.executeQuery();
			studentList = new ArrayList<StudentDataHold>();
			if(rs.next()){
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
			}
			else{
				throw new NullPointException("Class Not Present Exception");
			}
			
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			studentList = null;
		}
		return studentList;
	}
}
