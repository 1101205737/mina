package com.game.init;

import com.game.service.EquipService;
import com.util.SpringUtil;

public class EquipInit {

	public static void init(){
		EquipService service = (EquipService) SpringUtil.getBean("equipService");
		service.init();
	}
}
