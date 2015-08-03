package com.game.conf.bean;

import java.util.ArrayList;
import java.util.List;

import com.game.conf.NpcConfig;

public class NpcMap {

	private int id;
	private String name;
	private int pic;
	private int lvl;
	private List<Npc> npcs;
	private int npcMax;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pic
	 */
	public int getPic() {
		return pic;
	}
	/**
	 * @param pic the pic to set
	 */
	public void setPic(int pic) {
		this.pic = pic;
	}
	/**
	 * @return the lvl
	 */
	public int getLvl() {
		return lvl;
	}
	/**
	 * @param lvl the lvl to set
	 */
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	/**
	 * @return the npcs
	 */
	public List<Npc> getNpcs() {
		return npcs;
	}
	/**
	 * @param npcs the npcs to set
	 */
	public void setNpcs(int[] npcs) {
		this.npcs = new ArrayList<Npc>();
		for(int npc : npcs){
			Npc n = NpcConfig.get(npc);
			this.npcs.add(n);
		}
	}
	/**
	 * @return the npcMax
	 */
	public int getNpcMax() {
		return npcMax;
	}
	/**
	 * @param npcMax the npcMax to set
	 */
	public void setNpcMax(int npcMax) {
		this.npcMax = npcMax;
	}
	
	
	
}
