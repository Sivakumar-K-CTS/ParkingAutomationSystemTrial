package com.cts.daompl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cts.dao.EmployeeDao;
import com.cts.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private final String db_username="root";
	private final String db_password="root";
	private final String db_driver="com.mysql.jdbc.Driver";
	private final String db_url="jdbc:mysql://localhost:3306/adm017";
	Connection connectionObj=null;
	PreparedStatement pStatment=null;
	
	@Override
	public void addEmployee(Employee eObj) {
		try 
		{
			//step1: Load the driver
			Class.forName(db_driver);
			//step2: Get Connection
			connectionObj =DriverManager.getConnection(db_url, db_username, db_password);
			//step3: Write your queries
			String insertQuery="insert into employee_table(?,?,?,?)";
			pStatment = connectionObj.prepareStatement(insertQuery);
			
			/*eObj.setEmployeeId(1122);
			eObj.setEmployeeName("Kalaiselvan");
			eObj.setSalary(100000.00);
			eObj.setAge(45);*/
			//step4: Execute the Queries
			pStatment.setInt(1,eObj.getEmployeeId());
			pStatment.setString(2,eObj.getEmployeeName());
			pStatment.setDouble(3,eObj.getSalary());
			pStatment.setInt(4,eObj.getAge());
			
			pStatment.executeUpdate();
			System.out.println("Data has been Successfully Updated");
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			//step5: Close the pStatment and Connection
			if(pStatment!=null)
			{
				try
				{
					pStatment.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(connectionObj!=null)
			{
				try
				{
					connectionObj.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

}
