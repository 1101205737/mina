package com.game.conf.bean;

import java.util.List;
import java.util.Map;

public class Npc {

	private int id;
	
	private int pic;
	
	private String name;
	
	private int[] hores;
	
	private List gifs;

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
	 * @return the hores
	 */
	public int[] getHores() {
		return hores;
	}

	/**
	 * @param hores the hores to set
	 */
	public void setHores(int[] hores) {
		this.hores = hores;
	}

	/**
	 * @return the gifs
	 */
	public List getGifs() {
		return gifs;
	}

	/**
	 * @param gifs the gifs to set
	 */
	public void setGifs(List gifs) {
		this.gifs = gifs;
	}
	
	
	
}
