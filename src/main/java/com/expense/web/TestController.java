package com.expense.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expense.dto.ExpReportDTO;
import com.expense.dto.ExpStatusDTO;
import com.expense.dto.ExpValidationDTO;
import com.expense.service.ExpReportService;

import org.springframework.ui.Model;

@Controller
public class TestController {
	@Autowired
	ExpReportService expService;
	
//	@RequestMapping("default") 
    public List<ExpReportDTO> list_old() { 
		
        return expService.getAllExpReportDto();//"default"; 
    } 
	
	@RequestMapping("default") 
    public String explists(Model model) { 
		List<ExpReportDTO> expReportList=expService.getAllExpReportDto();
		model.addAttribute("list",expReportList);
        return "default";//"default"; 
    } 
	@RequestMapping("validateExp") 
    public String expValidateLists(Model model) { 
		List<ExpValidationDTO> expValidationList=expService.getAllExpValidationDto();
		model.addAttribute("list",expValidationList);
        return "validateExp";
    } 
	@RequestMapping("statusExp") 
    public String expstatusLists(Model model) { 
		List<ExpStatusDTO> expValidationList=expService.getExpenseStatusDto();
		model.addAttribute("list",expValidationList);
        return "statusExp";
    } 
}
/*
@Controller
public class TestController {
	@RequestMapping("default") 
    public String list() { 
        return "default"; 
    } 
}*/
