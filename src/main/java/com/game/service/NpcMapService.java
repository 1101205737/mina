package com.game.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.game.conf.NpcMapConfig;
import com.game.conf.bean.Npc;
import com.game.conf.bean.NpcMap;

@Service
public class NpcMapService {
	
	public List<Npc> getNpcByMap(Integer mapId){
		NpcMap map = NpcMapConfig.get(mapId);
		return map.getNpcs();
	}
}
