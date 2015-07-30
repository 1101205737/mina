package com.game.init;

import com.game.service.HoreService;
import com.util.SpringUtil;

public class HoreInit {

	public static void init(){
		HoreService service = (HoreService) SpringUtil.getBean("horeService");
		service.init();
	}
}
