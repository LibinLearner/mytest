package cn.itcast.core.mapper;

import java.util.List;

import cn.itcast.core.pojo.User;


public interface UserMapper {

	void saveUser(User user);

	List<User> findAll();

}
