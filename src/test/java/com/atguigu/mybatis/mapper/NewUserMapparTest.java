package com.atguigu.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.pojo.User;
import com.github.abel533.entity.Example;

public class NewUserMapparTest {
	
	private NewUserMappar newUserMappar;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		//代理对象
		this.newUserMappar = sqlSession.getMapper(NewUserMappar.class);
	}

	@Test
	public void testSelectOne() {
		User user = new User();
		user.setId(2L);
		User user2 = this.newUserMappar.selectOne(user);
		System.out.println(user2);
		
		
	}

	@Test
	public void testSelect() {
		User user2 = new User();
	//	user2.setId(3L);
	//	user2.setUsername("lisi");
		List<User> list = this.newUserMappar.select(user2);
		for(User user : list){
			System.out.println(user);
		}
	}

	@Test
	public void testSelectCount() {
		User user2 = new User();
		user2.setId(3L);
		int count = this.newUserMappar.selectCount(user2);
		System.out.println(count);
	}

	@Test
	public void testSelectByPrimaryKey() {
		User selectByPrimaryKey = this.newUserMappar.selectByPrimaryKey(1L);
		System.out.println(selectByPrimaryKey);
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setId(null);
		user.setUsername("zhangsan");
		user.setPassword("123456");
		user.setPhone("1380000000");
		user.setEmail("123@aa.com");
		this.newUserMappar.insert(user);
	}

	@Test
	public void testInsertSelective() {
		User user = new User();
		user.setId(null);
		user.setUsername("aaaaa");
		user.setPassword("123456");
		this.newUserMappar.insertSelective(user);
	}

	@Test
	public void testDelete() {
		User user = new User();
		user.setId(4L);
		this.newUserMappar.delete(user);
		
	}

	@Test
	public void testDeleteByPrimaryKey() {
		User user = new User();
		user.setId(5L);
		this.newUserMappar.deleteByPrimaryKey(user);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		User user = new User();
		user.setId(3L);
		user.setUsername("张三");
		user.setPassword(null);
		this.newUserMappar.updateByPrimaryKeySelective(user);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		User user = new User();
		user.setId(3L);
		user.setUsername("aaaaa");
		user.setPassword("000000");
		this.newUserMappar.updateByPrimaryKeySelective(user);
	}

	@Test
	public void testSelectCountByExample() {
		Example example = new Example(User.class);
		 example.createCriteria().andEqualTo("username", "zhangsan").andEqualTo("password", "123456");
		 int selectCountByExample = this.newUserMappar.selectCountByExample(example);
		 System.out.println(selectCountByExample);
		
	}

	@Test
	public void testDeleteByExample() {
		Example example = new Example(User.class);
		
		example.createCriteria().andEqualTo("username", "zhangsan").andEqualTo("password", "123456");
		int deleteByExample = this.newUserMappar.deleteByExample(example);
		System.out.println(deleteByExample);
	}

	@Test
	public void testSelectByExample() {
		Example example = new Example(User.class);
		
		example.createCriteria().andEqualTo("username", "张三").andEqualTo("password", "00000");
		List<User> list = this.newUserMappar.selectByExample(example);
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testUpdateByExampleSelective() {
		Example example = new Example(User.class);
		example.createCriteria().andEqualTo("username", "张三").andEqualTo("password", "000000");
		User user = new User();
		user.setUsername("123123123");
		
		this.newUserMappar.updateByExampleSelective(user,example);
	}

	@Test
	public void testUpdateByExample() {
		Example example = new Example(User.class);
		
		example.createCriteria().andEqualTo("username", "123123123").andEqualTo("password", "000000");
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123456");
		this.newUserMappar.updateByExample(user, example);
	}

}
