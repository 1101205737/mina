package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.conf.bean.Equip;
import com.game.service.EquipService;
import com.util.SpringUtil;

public class EquipAction {

	public static Map<String,Object> getEquipByHore(Integer horeId){
		EquipService service = (EquipService) SpringUtil.getBean("equipService");
		Map<String,Object> map = service.getEquipByHore(horeId);
		Map<String,Object> ret = new HashMap<String,Object>();
		ret.put("code", "0000");
		ret.put("equip", map);
		return ret;
	}
	
	public static Map<String,Object> getEquipBag(Integer userId){
		EquipService service = (EquipService) SpringUtil.getBean("equipService");
		List<Equip> list = service.getEquipBag(userId);
		Map<String,Object> ret = new HashMap<String,Object>();
		ret.put("code", "0000");
		ret.put("equipBag", list);
		return ret;
	}
}
