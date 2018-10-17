package com.bin.springboot.dao;

import com.bin.springboot.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer>{

	public User findUserById(Integer id);
}
