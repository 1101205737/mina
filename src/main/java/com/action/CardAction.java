package com.action;

import java.util.Map;

import com.game.service.WarService;

public class CardAction {

	public static Map extract(){
		Map map = WarService.test();
		return map;
	}
}
