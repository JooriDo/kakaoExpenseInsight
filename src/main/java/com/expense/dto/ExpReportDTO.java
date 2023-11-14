package com.expense.dto;
import lombok.Data;

//업무원가보고서 조회용 
@Data
public class ExpReportDTO {
	private String deptCd;
	private String deptNm;
	private String acntCd;
	private String acntNm;
	private String bdgtCd;
	private String bdgtNm;
	private String bdgtAllocAmt;
	private String consAmt;
	private String bdgtConsDif;
	private String expRateBfDis;
	private String consAmtAfDis;
	private String consDisBif;
	private String expRateAfDis;
		


	public ExpReportDTO(String deptCd, String deptNm, String acntCd, String acntNm, String bdgtCd, String bdgtNm,
			String bdgtAllocAmt, String consAmt, String bdgtConsDif, String expRateBfDis, String consAmtAfDis,
			String consDisBif, String expRateAfDis) {
		super();
		this.deptCd = deptCd;
		this.deptNm = deptNm;
		this.acntCd = acntCd;
		this.acntNm = acntNm;
		this.bdgtCd = bdgtCd;
		this.bdgtNm = bdgtNm;
		this.bdgtAllocAmt = bdgtAllocAmt;
		this.consAmt = consAmt;
		this.bdgtConsDif = bdgtConsDif;
		this.expRateBfDis = expRateBfDis;
		this.consAmtAfDis = consAmtAfDis;
		this.consDisBif = consDisBif;
		this.expRateAfDis = expRateAfDis;
	}
}
