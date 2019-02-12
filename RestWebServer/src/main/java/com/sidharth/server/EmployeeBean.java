package com.sidharth.server;

public class EmployeeBean {

	private int empID;
	private String empName;
	private String empDesignation;
	
	public EmployeeBean() {
		
	}
	
	public EmployeeBean(int empID, String empName, String empDesignation) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empDesignation = empDesignation;
	}

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
}
