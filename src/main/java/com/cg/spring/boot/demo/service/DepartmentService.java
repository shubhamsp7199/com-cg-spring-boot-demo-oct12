package com.cg.spring.boot.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Department;
import com.cg.spring.boot.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	private static final Logger LOG = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentRepository depRepository;
	
	public List<Department> getAllDepartments(){	
		LOG.info("Service getgetAllDepartments");
		return depRepository.findAll();
	}
	
	public Department getDepartmentById(int did) {
		LOG.info("Service getDepartmentById");
		return depRepository.findById(did).get();
		
	}
	
	public Department addDepartment(Department department) {
		LOG.info("Service addDepartment");
		if(!depRepository.existsById(department.getDid())) 
			return depRepository.save(department);
		LOG.info(department.getDid()+"Department dose not exist.");
			return null;
	}
	
	public Department updateDepartment(Department department) {
		LOG.info("Service updateDepartment");
		if (depRepository.existsById(department.getDid()))
			return depRepository.save(department);
		LOG.info(department.getDid() + " does not exist.");
		return null;
	}

	public int deleteDepartmentById(int did) {
		LOG.info("Service deleteDepartmentById");
		if (depRepository.existsById(did)) {
			depRepository.deleteById(did);
			return did;
		}
		LOG.info(did + " does not exist.");
		return 0;
	}
	
	

}
