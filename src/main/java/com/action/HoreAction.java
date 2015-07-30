package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.bean.UserHore;
import com.game.service.HoreService;
import com.util.SpringUtil;

public class HoreAction {

	public static Map<String,Object> getHoreByUser(Integer userId){
		System.out.println("hore...");
		HoreService service = (HoreService) SpringUtil.getBean("horeService");
		List<UserHore> list = service.getHoreByUser(userId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "0000");
		map.put("hores", list);
		return map;
	}
	
	
	public static Map<String,Object> getHoreBykId(){
		return null;
	}
	
	
	public static Map<String,Object> modfiyEquip(){
		return null;
	}
}
