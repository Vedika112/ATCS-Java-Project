package com.ia.covid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@RequestMapping("/info")
public ModelAndView covidData(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("display.jsp");

	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/student","postgres","password");
	Statement stmt=con.createStatement();
	ResultSet result=stmt.executeQuery("SELECT location,total_cases FROM coviddata WHERE new_cases> 1000 GROUP BY location,total_cases ORDER BY sum(new_cases) desc"
			+ "");
	while(result.next()) {
	mv.addObject("l",result.getString(1));
	mv.addObject("t",result.getString(2));
	}
	return mv;
}}