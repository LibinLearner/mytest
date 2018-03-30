package cn.itcast.core.service;

import java.util.List;

import cn.itcast.core.pojo.User;

public interface UserService {

	void saveUser(User user);

	List<User> findAll();

}
