package com.ia.covid;

import java.util.LinkedList;
import java.util.List;
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
	ResultSet result=stmt.executeQuery("SELECT location,total_cases FROM covidata WHERE new_cases> 1000 GROUP BY location,total_cases,new_cases ORDER BY new_cases desc"
			+ "");
	LinkedList l=new LinkedList();
	LinkedList l1=new LinkedList();
	while(result.next()) {
	l.add(result.getString(1));
	l1.add(result.getInt(2));
	}
	mv.addObject("location",l);
	mv.addObject("cases",l1);
	return mv;
}}