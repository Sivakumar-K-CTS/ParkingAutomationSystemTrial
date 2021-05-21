package com.cts.main;
import java.lang.*;
import java.util.*;
import com.cts.daompl.EmployeeDaoImpl;
import com.cts.model.Employee;
public class Main {

	public static void main(String[] args) {
		EmployeeDaoImpl employeeDaoImplObj =  new EmployeeDaoImpl();
		Employee eObj = new Employee();
		eObj.setEmployeeId(1122);
		eObj.setEmployeeName("Kalaiselvan");
		eObj.setSalary(100000.00);
		eObj.setAge(45);
		employeeDaoImplObj.addEmployee(eObj);
	}

}
