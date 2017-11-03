package com.capital.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capital.one.datamodelbeans.Employee;
import com.capital.one.service.EmployeeService;
import com.capital.one.service.LoginService;



@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	@RequestMapping(value = "/getSearchList", method=RequestMethod.GET)
	public @ResponseBody List<String[]> getListToSearch(){
		List<String[]> myList =  es.getSearchList();
		
		//Commented out real line above and filling in dummy data to test return
//		List<String[]> myList = new ArrayList<String[]>();
//		String[] listOne = {"Employee","1","dcrites","David","Crites","dcrites@place.com"};
//		String[] listTwo = {"Team","1","mastermind",null,null,"teammastermind@capitalone.com"};
//		myList.add(listOne);
//		myList.add(listTwo);
		return myList;
	}
	
	  @RequestMapping(value="/login/", method=RequestMethod.GET)
	    public @ResponseBody ResponseEntity<Object> getUsernamepassword(@RequestParam String username,@RequestParam String password){
		System.out.println("here!!");
		  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");		
		  Employee employee = (Employee) context.getBean("employee");
		  LoginService loginService = (LoginService)context.getBean("loginService");
		  employee.setUserName(username);
		  employee.setPassword(password);
	       
	        employee = loginService.authenticateUser(employee.getUserName(), employee.getPassword());
			return ResponseEntity.ok(employee);
	    }	  
}