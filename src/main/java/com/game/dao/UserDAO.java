package com.game.dao;

import java.util.List;

import com.dao.core.MyBatisRepository;
import com.game.bean.User;

@MyBatisRepository
public interface UserDAO {

	public List<User> getAllUser();
}
