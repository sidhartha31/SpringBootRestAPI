package com.sidharth.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyRestController {

	@GetMapping("/hello")
	public ResponseEntity<ResponseBean> sayHello() {

		ResponseBean response = new ResponseBean();
		response.setStatus(200);
		response.setMessage("Hello from RestAPI!");

		return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
	}

	@PostMapping("/postEmployee")
	public ResponseEntity<ResponseBean> postEmployeeData(@RequestBody EmployeeBean employee) {

		ResponseBean response = new ResponseBean();

		if(employee != null) {
			response.setStatus(201);
			response.setMessage("Employee Data Posted Succesfully!");
			return new ResponseEntity<ResponseBean>(response, HttpStatus.CREATED);
		}

		response.setStatus(400);
		response.setMessage("Employee Data Not Posted Succesfully!");
		return new ResponseEntity<ResponseBean>(response, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getEmployee/{empID}")
	public ResponseEntity<EmployeeBean> getEmployeeData(@PathVariable("empID") Integer empID) {

		EmployeeBean employee = new EmployeeBean();

		if(empID > 0) {
			employee.setEmpID(empID);
			employee.setEmpName("Sidharth");
			employee.setEmpDesignation("Software Engineer");
			return new ResponseEntity<EmployeeBean>(employee, HttpStatus.OK);
		}
		return new ResponseEntity("Incorrect Employee ID!", HttpStatus.BAD_REQUEST);
	}
}
