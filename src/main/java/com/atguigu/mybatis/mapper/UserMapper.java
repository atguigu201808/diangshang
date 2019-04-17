package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

public interface UserMapper {
	
	public User selectUserById(Long id);

}
