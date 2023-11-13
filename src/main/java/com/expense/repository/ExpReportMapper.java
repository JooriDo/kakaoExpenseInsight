package com.expense.repository;
import java.util.List;

import org.apache.ibatis.annotations.Select;

//https://ldgeao99-developer.tistory.com/642
//https://devlog-wjdrbs96.tistory.com/200
//import org.apache.ibatis.annotations.Mapper;

import com.expense.dto.ExpReportDTO;
//@Mapper
public interface ExpReportMapper {
	@Select("SELECT a.DEPT_CD as deptCd"
			+",b.DEPT_NM as deptNm "
			+",a.ACNT_CD as acntCd"
			+",c.ACNT_NM as acntNm"
			+",a.bdgt_cd as bdgtCd"
			+",d.\"bdgt_nm\" as bdgtNm"
			+",a.BDGT_ALLOC_AMT as bdgtAllocAmt"
			+",a.CONS_AMT as consAmt"
			+",a.BDGT_CONS_DIF as bdgtConsDif"
			+",a.EXP_RATE_BF_DIS as expRateBfDis"
			+",a.CONS_AMT_AF_DIS as consAmtAfDis"
			+",a.CONS_DIS_BIF as consDisBif"
			+",a.EXP_RATE_AF_DIS as expRateAfDis "
			+"FROM EXP_REPORT_DTL a "
			+"LEFT OUTER JOIN DEPT_MNG b ON a.DEPT_CD =b.DEPT_CD "
			+"LEFT OUTER JOIN ACNT_MNG c ON a.ACNT_CD =c.\"acnt_cd\"" 
			+"LEFT OUTER JOIN BDGT_MNG d ON a.BDGT_CD =d.\"bdgt_cd\" "
			+"WHERE 1=1")
	 List <ExpReportDTO >selectAll();
}
