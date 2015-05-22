package com.game.bean;

import com.game.service.Faction;



/**
 * Tank
 * @author Administrator
 *
 */
public class Army {
	
	private int point;

	private int pid;
	
	private int pos;
	
	private int num;
	
	private int atk;
	
	private int def;
	
	private int speed;
	
	private int distance;
	
	private int time;

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the pos
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	///=========================
	public boolean attack(Faction f,StringBuffer report){
		Army army = findAttackObject(f);
		if(army == null)
			return false;
		int attack = atk-army.getDef();//伤害公式
		army.setNum(army.getNum() - attack);
		report.append(army.getPoint()+","+army.getPos()+","+attack+"#");
		return true;
	}
	
	public Army findAttackObject(Faction f){
		Army army = f.getArmys().get(pos-1);
		if(army.getNum() > 0 && pos < 3)
			return army;
		else{
			for(int i=0;i<f.getArmys().size();i++){
				army = f.getArmys().get(i);
				if(army.getNum() > 0)
					return army;
			}
			System.out.println("over");
			return null;
		}
			
	}
}
