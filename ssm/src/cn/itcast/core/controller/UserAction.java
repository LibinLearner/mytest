package cn.itcast.core.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.pojo.User;
import cn.itcast.core.service.UserService;

@Controller
public class UserAction {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/toInsert.action")
	public String toInsert() {
		return "insert";
	}

	@RequestMapping(value = "/user/insert.action")
	public String insert(String name, String birthday,Model model) throws Exception {
		User user = new User();
		// 时间转换
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(birthday);
		// 设置属性
		user.setBirthday(date);
		user.setName(name);
		userService.saveUser(user);

		// 保存后查询所有用户,存入userList并返回list页面
		List<User> userList = userService.findAll();
		for (User user2 : userList) {
			System.out.println(user2);
		}
		model.addAttribute("userList", userList);
		return "list";
	}

}
