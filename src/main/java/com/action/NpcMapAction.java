package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.conf.bean.Npc;
import com.game.service.NpcMapService;
import com.util.SpringUtil;

public class NpcMapAction {

	public static Map<String ,Object> getNpcByMap(Integer mapId){
		NpcMapService service = (NpcMapService) SpringUtil.getBean("npcMapService");
		List<Npc> npcs= service.getNpcByMap(mapId);
		Map<String ,Object> ret = new HashMap<String ,Object>();
		ret.put("npcs", npcs);
		ret.put("code", "0000");
		return ret;
	}
}
