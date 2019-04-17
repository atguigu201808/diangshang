package com.atguigu.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.pojo.User;

public class UserMapperTest {
	
	SqlSession sqlSession;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession(true);
	}

	@Test
	public void testSelectUserById() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectUserById(1L);
		System.out.println(user);
		
			
	}
	
	@Test
	public void aa(){
		int i = 2;
		if(i != 0){
			System.out.println("2222");
		}
		System.out.println("02020");
		
		if(i == 0){
			System.out.println("000");
		}
		System.out.println("opopop");
	}

}
