package com.bin.test;



import com.bin.springboot.dao.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RunApplication {

	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		Map<String,List<User>> userMap = userList.stream().collect(Collectors.groupingBy(User::getUserName));
	}

}
