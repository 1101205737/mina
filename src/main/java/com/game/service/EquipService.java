package com.game.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bean.UserEquip;
import com.game.conf.bean.Equip;
import com.game.dao.EquipDAO;

@Service
public class EquipService {

	private final Map<Integer,UserEquip> ID_OBJ = new ConcurrentHashMap<Integer,UserEquip>();
	private final Map<Integer,List<Integer>> UID_IDS = new ConcurrentHashMap<Integer, List<Integer>>();
	
	
	@Autowired
	private EquipDAO equipDAO;
	
	public void init(){
		List<UserEquip> list = equipDAO.queryAll();
		if(null != list && list.size() > 0){
			
		}
	}
}
