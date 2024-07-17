package com.lbi.persitence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JDBCTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 단위 테스트
	@Test
	public void testConnection() {
		try (Connection con = dataSource.getConnection(); SqlSession session = sqlSessionFactory.openSession();) {
			System.out.println("con : " + con);
			System.out.println("session : " + session);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
