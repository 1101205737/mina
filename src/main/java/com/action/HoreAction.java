package com.action;

import java.util.HashMap;
import java.util.Map;

import com.game.service.HoreService;
import com.util.SpringUtil;

public class HoreAction {

	public static Map getHoreByUser(Integer userId){
		System.out.println("hore...");
		HoreService service = (HoreService) SpringUtil.getBean("horeService");
		service.getHoreByUser(userId);
		Map map = new HashMap();
		map.put("code", "success");
		return map;
	}
}
