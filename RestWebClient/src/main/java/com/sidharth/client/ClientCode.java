package com.sidharth.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class ClientCode {

	public static final String GET_HELLO_URI = "http://localhost:8085/rest/hello";
	public static final String POST_EMPLOYEE_URI = "http://localhost:8085/rest/postEmployee";
	public static final String GET_EMPLOYEE_URI = "http://localhost:8085/rest/getEmployee/";
	
	public static void main(String[] args) {

		invokeGetHello();
		System.out.println();
		invokeGetEmployee(5);
		System.out.println();
		
		EmployeeBean employee = new EmployeeBean();
		employee.setEmpID(123);
		employee.setEmpName("Sidharth");
		employee.setEmpDesignation("Software Engineer");
		invokePostEmployee(employee);
	}

	private static void invokeGetHello() {
		try {
			System.out.println("Invoking GET Hello Method..");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet httpGet = new HttpGet(GET_HELLO_URI);
			HttpResponse response = client.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
		    String stringOutput = EntityUtils.toString(entity);
		    
		    ResponseBean responseBean = new Gson().fromJson(stringOutput, ResponseBean.class);
		    System.out.println("Status Code: "+responseBean.getStatus());
		    System.out.println("Status Message: "+responseBean.getMessage());
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	private static void invokeGetEmployee(int empID) {
		try {
			System.out.println("Invoking GET Employee Method..");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet httpGet = new HttpGet(GET_EMPLOYEE_URI+empID);
			HttpResponse response = client.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
		    String stringOutput = EntityUtils.toString(entity);
		    
		    EmployeeBean employeeBean = new Gson().fromJson(stringOutput, EmployeeBean.class);
		    System.out.println("Employee ID: "+employeeBean.getEmpID());
		    System.out.println("Employee Name: "+employeeBean.getEmpName());
		    System.out.println("Employee Designation: "+employeeBean.getEmpDesignation());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void invokePostEmployee(EmployeeBean employee) {
		try {
			System.out.println("Invoking POST Employee Method..");
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost(POST_EMPLOYEE_URI);
			StringEntity postingString = new StringEntity(new Gson().toJson(employee));
			httpPost.setEntity(postingString);
			httpPost.addHeader("Content-Type", "application/json");
			
			HttpResponse response = client.execute(httpPost);
			
			HttpEntity entity = response.getEntity();
		    String stringOutput = EntityUtils.toString(entity);
		    
		    ResponseBean responseBean = new Gson().fromJson(stringOutput, ResponseBean.class);
		    System.out.println("Status Code: "+responseBean.getStatus());
		    System.out.println("Status Message: "+responseBean.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
