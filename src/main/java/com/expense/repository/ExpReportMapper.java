package com.expense.repository;
import java.util.List;

import org.apache.ibatis.annotations.Select;

//https://ldgeao99-developer.tistory.com/642
//https://devlog-wjdrbs96.tistory.com/200
//import org.apache.ibatis.annotations.Mapper;

import com.expense.dto.ExpReportDTO;
import com.expense.dto.ExpStatusDTO;
import com.expense.dto.ExpValidationDTO;
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
	
	@Select("--총계정원장 비용합계\n"
			+ "SELECT  '총계정원장비용합계' AS title\n"
			+ "		,sum(DR_AMT)-sum(CR_AMT) AS validateExp\n"
			+ "FROM ACNT_LEDGER al \n"
			+ " LEFT OUTER JOIN ACNT_MNG am ON al.ACNT_CD =am.\"acnt_cd\" \n"
			+ "WHERE 1=1\n"
			+ "  AND BDGT_DTE BETWEEN TO_CHAR(ADD_MONTHS(TRUNC(TO_DATE(2023, 'yyyy'), 'y'), 1*3-3), 'yyyymmdd') AND TO_CHAR(ADD_MONTHS(TRUNC(TO_DATE(2023, 'yyyy'), 'y'), 1*3)-1, 'yyyymmdd') \n"
			+ "  AND am.\"acnt_tp\" ='6'\n"
			+ "--  AND al.DEPT_CD='001'\n"
			+ "  UNION all\n"
			+ " -- 부서별 비용계정합계시산표 합계 (배부전후)\n"
			+ " SELECT '부서별비용계정합계시산표(배부전)'AS title , sum(DR_SUM)-sum(CR_SUM) AS validateExp\n"
			+ " FROM DEPT_EXP_TRIALBAL_DTL a \n"
			+ " wHERE TRIALBAL_ID = '2023'||'-'||'1'||'-'||'BF'\n"
			+ "-- AND dept_cd='001'\n"
			+ "  UNION all\n"
			+ "SELECT  '부서별비용계정합계시산표(배부후)'AS title ,sum(DR_SUM)-sum(CR_SUM) AS validateExp\n"
			+ " FROM DEPT_EXP_TRIALBAL_DTL a \n"
			+ " wHERE TRIALBAL_ID = '2023'||'-'||'1'||'-'||'AF'\n"
			+ "-- AND dept_cd='001'\n"
			+ "UNION all\n"
			+ "--업무원가보고서상 실제원가\n"
			+ "SELECT '업무원가보고서상 실제집행액(배부전)'AS title, sum(CONS_AMT) AS validateExp\n"
			+ "FROM EXP_REPORT_DTL a \n"
			+ "WHERE EXPREPORT_ID ='2023'||'-'||'1'\n"
			+ "--AND DEPT_CD ='001'\n"
			+ "UNION ALL \n"
			+ "-- 배부후 원가 합 얘는 부서단위일땐 의미없음 \n"
			+ "SELECT '업무원가보고서상 배부후원가(배부후)'AS title,sum(CONS_AMT_AF_DIS) AS validateExp\n"
			+ "FROM EXP_REPORT_DTL a \n"
			+ "WHERE EXPREPORT_ID ='2023'||'-'||'1'")
	 List <ExpValidationDTO >selectValidation();
	
	@Select("--판매관리비용 현황관리\n"
			+ "SELECT al.DEPT_CD AS deptCd\n"
			+ "	   ,dm.dept_nm AS deptNm\n"
			+ "	   ,al.ACNT_CD AS acntCd \n"
			+ "	   ,am.ACNT_NM AS acntNm\n"
			+ "	   ,al.BDGT_CD AS bdgtCd  \n"
			+ "	   ,bm.\"bdgt_nm\" AS bdgtNm\n"
			+ "	   ,sum(DR_AMT)-sum(CR_AMT) AS expense \n"
			+ "FROM ACNT_LEDGER al \n"
			+ " LEFT OUTER JOIN ACNT_MNG am ON al.ACNT_CD =am.\"acnt_cd\" \n"
			+ " LEFT OUTER JOIN DEPT_MNG dm ON al.DEPT_CD =dm.DEPT_CD \n"
			+ " LEFT OUTER JOIN BDGT_MNG bm ON al.BDGT_CD =bm.\"bdgt_cd\" \n"
			+ "WHERE am.PR_ACNT_CD ='61000000000' --판관비계정 \n"
			+ "AND BASE_DTE BETWEEN '20230101'AND '20231231'\n"
			+ "--AND DEPT_CD =''\n"
			+ "GROUP BY al.DEPT_CD ,dm.dept_nm,al.ACNT_CD ,am.ACNT_NM ,al.BDGT_CD ,bm.\"bdgt_nm\" ")
	 List <ExpStatusDTO >selecExpStatus();
}
