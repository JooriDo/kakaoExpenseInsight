package com.expense.dto;
import lombok.Data;

//업무원가보고서 검증용 
@Data
public class ExpValidationDTO {
	private String title;
	private int validateExp;

	public ExpValidationDTO(String title, int validateExp) {
		super();
		this.title = title;
		this.validateExp = validateExp;
	}
}
