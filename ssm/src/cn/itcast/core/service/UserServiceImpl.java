package cn.itcast.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.core.mapper.SolrDao;
import cn.itcast.core.mapper.UserMapper;
import cn.itcast.core.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public List<User> findAll() {
		//mybatis²éÑ¯
		return userMapper.findAll();
		//solrË÷Òý¿â²éÑ¯
//		SolrDao solrDao = new SolrDao();
//		return solrDao.findAllBySolr();
	}

	
	@Override
	public void saveUser(User user) {
		
		userMapper.saveUser(user);
	}

}
