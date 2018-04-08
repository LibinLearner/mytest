package cn.asiainfo.mybatis.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.asiainfo.mybatis.mapper.UserMapper;
import cn.asiainfo.mybatis.pojo.User;

public class spring_mybatis_test {

	@Test
	public void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class);
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
	}

}
