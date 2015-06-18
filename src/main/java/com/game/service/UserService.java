package com.game.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bean.User;
import com.game.dao.UserDAO;

@Service
public class UserService {
	

	public static final Map<Integer, User> id_u = new ConcurrentHashMap<Integer, User>();
	public static final Map<Integer, User> update_u = new ConcurrentHashMap<Integer, User>();
	
	@Autowired
	private UserDAO userDAO;
	
	
	public void init(){
		List<User> list = userDAO.getAllUser();
		if(list != null && list.size() > 0){
			for(User u : list)
				putMem(u);
		}
	}
	
	
	public void put(User u){
		if(u.getId() > 0){
			putMem(u);
			putUpdate(u);
		}
		
	}
	
	public void putMem(User u){
		if(u.getId() > 0)
			id_u.put(u.getId(), u);
	}
	
	public void putUpdate(User u){
		update_u.put(u.getId(), u);
	}
	
	public void update(){
		
	}
}
