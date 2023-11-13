package com.expense;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/* https://offbyone.tistory.com/391
 * https://abn-abn.tistory.com/255
 * src/main/resources - static 폴더 : 리소스 파일 ( js, image, css ... ) 같은 정적인 요소들을 저장하는 폴더
src/main/resources - templates : jsp가 아닌, 템플릿 위치
https://recordsoflife.tistory.com/1062 타임리프 에서javascrpit 함수호출하기


<오라클 연동 > https://shanepark.tistory.com/400
오라클 캐릭터 셋 연결 https://rimkongs.tistory.com/313
docker start 96e9f06cb16d

회계 계정체계 참고 https://blog.naver.com/PostView.nhn?blogId=lghmms&logNo=222202535110
 * https://my-trash-code.tistory.com/15 화면에 뿌려주는법
 * */
@SpringBootApplication
@MapperScan("com.expense.repository")
public class ExpenseInsightKakaobankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseInsightKakaobankApplication.class, args);
	}
	/* 오라클연동*/
	@Bean
	 public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	        
	        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
	    
	        bean.setDataSource(dataSource); //데이터소스 설정
	        
	        return bean.getObject();
	    }
	    @Bean
	    public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
	        return new SqlSessionTemplate(factory);
	    }
}
