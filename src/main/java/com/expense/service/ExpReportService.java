package com.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dto.ExpReportDTO;
import com.expense.dto.ExpStatusDTO;
import com.expense.dto.ExpValidationDTO;
import com.expense.repository.ExpReportMapper;

@Service
public class ExpReportService {
	@Autowired
	ExpReportMapper expReportMapper;
	
	public List<ExpReportDTO> getAllExpReportDto() {
		return expReportMapper.selectAll();
	}
	
	public List<ExpValidationDTO> getAllExpValidationDto() {
		return expReportMapper.selectValidation();
	}
	
	public List<ExpStatusDTO> getExpenseStatusDto() {
		return expReportMapper.selecExpStatus();
	}
}
