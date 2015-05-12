package com.game.service;

import java.util.List;

import com.game.bean.Army;

public class Faction {

	private int speed;
	
	private int attack;
	
	private double attackPlus;//部队攻击加成
	
	private int defense;
	
	private double defensePlus;//部队防御加成
	
	private List<Army> armys;

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the armys
	 */
	public List<Army> getArmys() {
		return armys;
	}

	/**
	 * @param armys the armys to set
	 */
	public void setArmys(List<Army> armys) {
		this.armys = armys;
	}

	/**
	 * @return the attackPlus
	 */
	public double getAttackPlus() {
		return attackPlus;
	}

	/**
	 * @param attackPlus the attackPlus to set
	 */
	public void setAttackPlus(double attackPlus) {
		this.attackPlus = attackPlus;
	}

	/**
	 * @return the defensePlus
	 */
	public double getDefensePlus() {
		return defensePlus;
	}

	/**
	 * @param defensePlus the defensePlus to set
	 */
	public void setDefensePlus(double defensePlus) {
		this.defensePlus = defensePlus;
	}
	
	
}
