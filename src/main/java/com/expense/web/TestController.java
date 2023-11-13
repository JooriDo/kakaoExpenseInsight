package com.expense.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expense.dto.ExpReportDTO;
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
}
/*
@Controller
public class TestController {
	@RequestMapping("default") 
    public String list() { 
        return "default"; 
    } 
}*/
