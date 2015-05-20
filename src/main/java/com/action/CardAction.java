package com.action;

import java.util.HashMap;
import java.util.Map;

import com.game.service.WarService;

public class CardAction {

	public static Map extract(){
		Map map = WarService.test();
		return map;
	}
	
	public static Map test(){
		Map map = new HashMap();
		map.put("report", "中文");
		return map;
	}
}
