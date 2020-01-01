package com.srf.servlet;

import java.io.IOException;
import java.io.PrintWriter;


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
 * Servlet implementation class FindResByRoll
 */
@WebServlet("/FindResByRoll")
public class FindResByRoll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	AssignResultControler addResult = null;

	PrintWriter pw = null;
	private static Logger log = Logger.getLogger(FindResByRoll.class);
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
		int rollNo = Integer.parseInt(request.getParameter("roll"));
		log.info("clint Entered the RollNo:"+rollNo);
		log.info("contreler Layer is being Called");
		StudentResultHold result = addResult.findResult(rollNo);
		// student found in db
		if (null != result) {
			StudentDataHold res1 = result.getSdh();
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
			pw.println("<tr>");
			pw.println("<td>" + res1.getrNo() + "</td>");
			pw.println("<td>" + res1.getfName() + "</td>");
			pw.println("<td>" + res1.getlName() + "</td>");
			pw.println("<td>" + res1.getAddress() + "</td>");
			pw.println("<td>" + res1.getClazz() + "</td>");
			pw.println("<td>" + res1.getSub1() + "</td>");
			pw.println("<td>" + res1.getSub2() + "</td>");
			pw.println("<td>" + res1.getSub3() + "</td>");
			pw.println("<td>" + result.getAvg() + "</td>");
			pw.println("<td>" + result.getRes() + "</td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");
		} else {
			// student not found error page
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<h1 align='center' style='color:red'>STUDENT NOT FOUND IN DB</h1>");
			
			pw.println("</body>");
			pw.println("</html>");
		}

	}

}
