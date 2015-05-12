package com.game.bean;

import java.util.List;

/**
 * 英雄
 * @author dell
 *
 */
public class Hero {
	
	private int power;//力量
	
	private double powerPlus;//部队生命加成

	private int quick;//敏捷,指挥出兵的速度
	
	private int command;//智力
	
	private double commandPlus;//英雄技能伤害加成
	
	//========================
	
	private int attack;
	
	private double attackPlus;//部队攻击加成
	
	private int defense;
	
	private double defensePlus;//部队防御加成
	
	private List<Equip> equips;
	
	private List<Army> armys;

	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * @return the powerPlus
	 */
	public double getPowerPlus() {
		return powerPlus;
	}

	/**
	 * @param powerPlus the powerPlus to set
	 */
	public void setPowerPlus(double powerPlus) {
		this.powerPlus = powerPlus;
	}

	/**
	 * @return the quick
	 */
	public int getQuick() {
		return quick;
	}

	/**
	 * @param quick the quick to set
	 */
	public void setQuick(int quick) {
		this.quick = quick;
	}

	/**
	 * @return the command
	 */
	public int getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(int command) {
		this.command = command;
	}

	/**
	 * @return the commandPlus
	 */
	public double getCommandPlus() {
		return commandPlus;
	}

	/**
	 * @param commandPlus the commandPlus to set
	 */
	public void setCommandPlus(double commandPlus) {
		this.commandPlus = commandPlus;
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
	
	
}
