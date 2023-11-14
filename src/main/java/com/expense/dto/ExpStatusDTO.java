package com.expense.dto;
import lombok.Data;

//업무원가보고서 조회용 
@Data
public class ExpStatusDTO {

	
	private String deptCd;
	private String deptNm;
	private String acntCd;
	private String acntNm;
	private String bdgtCd;
	private String bdgtNm;
	private int expense;


	public ExpStatusDTO(String deptCd, String deptNm, String acntCd, String acntNm, String bdgtCd, String bdgtNm,
			int expense) {
		super();
		this.deptCd = deptCd;
		this.deptNm = deptNm;
		this.acntCd = acntCd;
		this.acntNm = acntNm;
		this.bdgtCd = bdgtCd;
		this.bdgtNm = bdgtNm;
		this.expense = expense;
		
	}
}
