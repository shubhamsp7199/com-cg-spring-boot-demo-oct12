package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		LOG.info("Service getAllEmployees");
		return empRepository.findAll();
	}

//	public Employee getEmployeeById(int eid) {
//		Log.info("getEmployeeById");
//		return empRepository.findById(eid).get();
//	}

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById");
		Optional<Employee> empOpt = empRepository.findById(eid);
		if (empOpt.isPresent()) {
			LOG.info("Employee is available.");
			return empOpt.get();
		} else {
			LOG.info("Employee is NOT available.");
			throw new EmployeeNotFoundException(eid + " this employee is not found.");
		}
	}

	public Employee addEmployee(Employee employee) {
		LOG.info("Service addEmployee");
		if (!empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		else
		throw new EmployeeNotFoundException(employee.getEid() + " already exists.");
	}
		

	public Employee updateEmployee(Employee employee) {
		LOG.info("Service updateEmployee");
		if (empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		else
		throw new EmployeeNotFoundException (employee + " does not exist.");
		
	}

	
	 public Employee deleteEmployeeById(int eid) {
	        LOG.info("deleteEmployeeById");
	        Optional<Employee> empOpt = empRepository.findById(eid);
	        if (empOpt.isPresent()) {
	            empRepository.deleteById(eid);
	            return empOpt.get();
	        } else {
	            throw new EmployeeNotFoundException(eid + " this employee does not exist.");
	        }
	    }
	 
	 
	 
	 public List<Employee> getEmployeeByFirstName(String firstName) {
			LOG.info("getEmployeeByFirstName");
		List <Employee> empOpt = empRepository.findByFirstName(firstName);
		if(!empOpt.isEmpty()){
			LOG.info("Employee is available.");
			return empOpt;
			
		} else {
			LOG.info("Employee is NOT available.");
			throw new EmployeeNotFoundException(firstName + " this employee is not found.");	
		}
	 }
	 
	 
	 public List<Employee> getEmployeeBySalary(double salary) {
			LOG.info("getEmployeeBySalary");
		List <Employee> empOpt = empRepository.findBySalary(salary);
		if(!empOpt.isEmpty()){
			LOG.info("Employee is available.");
			return empOpt;
			
		} else {
			LOG.info("Employee is NOT available.");
			throw new EmployeeNotFoundException(salary + " this employee is not found.");	
		}
	 }
	 
	 public List<Employee> getEmployeeBySalaryGreaterThan(double salary) {
			LOG.info("getEmployeeBySalaryGreaterThan");
		List <Employee> empOpt = empRepository.findBySalaryGreaterThan(salary);
		if(!empOpt.isEmpty()){
			LOG.info("Employee is available.");
			return empOpt;
		} else {
			LOG.info("Employee is NOT available.");
			throw new EmployeeNotFoundException(salary + " this employee is not found.");	
		}
	 }
	 
	 public List<Employee> getEmployeeBySalaryLessThan(double salary) {
			LOG.info("getEmployeeBySalaryLessThan");
		List <Employee> empOpt = empRepository.findBySalaryLessThan(salary);
		if(!empOpt.isEmpty()){
			LOG.info("Employee is available.");
			return empOpt;
		} else {
			LOG.info("Employee is NOT available.");
			throw new EmployeeNotFoundException(salary + " this employee is not found.");	
		}
	 }

	 public List<Employee> getEmployeeBySalaryInBetween(double salary1, double salary2) {
			LOG.info("getEmployeeBySalaryBetween");
		List <Employee> empOpt = empRepository.findBySalaryBetween(salary1, salary2);
		if(!empOpt.isEmpty()){
			LOG.info("Employee is available.");
			return empOpt;
		} else {
			LOG.info("Employee is NOT available.");
			throw new EmployeeNotFoundException(salary1 +" " +salary2 + " this employee is not found");	
		}
	 }
		
		
	
//	public int deleteEmployeeById(int eid) {
//		LOG.info("Service deleteEmployeeById");
//		if (empRepository.existsById(eid)) {
//			empRepository.deleteById(eid);
//			return eid;
//		}
//		LOG.info(eid + " does not exist.");
//		return 0;
//	}
}

////@Component
//
//@Service
//public class EmployeeService {
//
//	private List<Employee> empList = new ArrayList<>();
//
//	{
//		empList.add(new Employee(101, "Sonu", 10.5));
//		empList.add(new Employee(102, "Monu", 15.5));
//		empList.add(new Employee(103, "Tonu", 12.5));
//	}
//
//	public List<Employee> getAllEmployees() {
//		System.out.println("Service getAllEmployees");
//		return empList;
//	}
//
//	public Employee getEmployeeById(int eid) {
//		System.out.println("Service getEmployeeById");
//		return empList.stream().filter(e -> eid == e.getEid()).findAny().orElse(null);
//	}
//
//	public Employee addEmployee(Employee employee) {
//		empList.add(employee);
//		return employee;
//	}
//
//}