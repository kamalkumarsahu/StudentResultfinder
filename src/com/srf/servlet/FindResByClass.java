package com.srf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.srf.beans.StudentDataHold;
import com.srf.beans.StudentResultHold;
import com.srf.contoller.AssignResultControler;

/**
 * .
 *  implementation class FindResByRoll
 */
@WebServlet("/FindResByClass")
public class FindResByClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindResByClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */

	AssignResultControler addResult = null;

	PrintWriter pw = null;
	private static Logger log = Logger.getLogger(FindResByClass.class);

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		addResult = new AssignResultControler();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		pw = response.getWriter();
		int clazz = Integer.parseInt(request.getParameter("class"));
		log.info("Class data resd from clint side:"+clazz);
		log.info("the controler layer is being called");
		List<StudentResultHold> listStudentResultHold = addResult.findStudentByClass(clazz);

		if (null != listStudentResultHold) {
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<h1 align='center'>STUDENT RESULT</h1>");
			pw.println("<table align='center' border='1'>");
			pw.println("<tr>");
			pw.println("<th>ROLLNO</th>");
			pw.println("<th>FIRSTNAME</th>");
			pw.println("<th>LASTNAME</th>");
			pw.println("<th>ADDRESS</th>");
			pw.println("<th>CLASS</th>");
			pw.println("<th>SUB1</th>");
			pw.println("<th>SUB2</th>");
			pw.println("<th>SUB3</th>");
			pw.println("<th>PER</th>");
			pw.println("<th>RESULT</th>");
			pw.println("</tr>");
			// repeat the tr to complete the table
			for(StudentResultHold studentResult:listStudentResultHold){
				StudentDataHold student = studentResult.getSdh();
				pw.println("<tr>");
				pw.println("<td>" + student.getrNo() + "</td>");
				pw.println("<td>" + student.getfName() + "</td>");
				pw.println("<td>" + student.getlName() + "</td>");
				pw.println("<td>" + student.getAddress() + "</td>");
				pw.println("<td>" + student.getClazz() + "</td>");
				pw.println("<td>" + student.getSub1() + "</td>");
				pw.println("<td>" + student.getSub2() + "</td>");
				pw.println("<td>" + student.getSub3() + "</td>");
				pw.println("<td>" + studentResult.getAvg() + "</td>");
				pw.println("<td>" + studentResult.getRes() + "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");
		} else {
			// error page
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<h1 align='center' style='color:red'>Class not there in sisu mandira.</h1>");
			pw.println("</body>");
			pw.println("</html>");
		}
		
		
	}

}
