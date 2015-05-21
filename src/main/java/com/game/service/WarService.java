package com.game.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.bean.Army;
import com.game.bean.ArmysConfig;


/**
 * 5v5战斗
 * 1、初始化状态
 * 2、循环
 * 3、判断状态
 * 4、速度监听
 * 5、寻找攻击对象
 * 6、攻击
 * 7、扣血
 * @author Administrator
 *
 */
public class WarService {

	public static StringBuffer war(Faction f1,Faction f2){
		SpeedListener listener = new SpeedListener();
		listener.registe(f1,1);
		listener.registe(f2,2);
		StringBuffer report = new StringBuffer();
		boolean isFinished = false;//战斗是否结束
		while(!isFinished){
			StringBuffer report3 = new StringBuffer();
			List<Army> list = listener.forward(report3);
			if(list.size() > 0){
				String[] temps = null;
				String temp ="";
				if(list.size() > 1){
					temp = report3.substring(report3.indexOf("/")+1);
					temps = temp.split("/");
				}else{
					report.append(report3.toString());
					temps = null;
				}
				int i=0;
				for(Army a : list){
					if(temps != null){
						report.append("0/"+temps[i++]+"/");//相同时间内攻击延迟0ms
					}
					if(a.getPoint() == 1){
						if(!a.attack(f2,report))
							isFinished = true;
					}else{
						if(!a.attack(f1,report))
							isFinished = true;
					}
				}
			}
		}
		return report;
	}
	
	
	public static Map test(){
		
		ArmysConfig.initConfig();
		
		//================================
		
		Faction f1 = new Faction();
		f1.setSpeed(200);
		f1.setAttack(1500);
		f1.setAttackPlus(0.15);
		f1.setDefense(1200);
		f1.setDefensePlus(0.12);
		List<Army> armys1 = new ArrayList<Army>();
		Army a1 = new Army();
		a1.setPid(1);
		a1.setPos(1);
		a1.setNum(100);
		a1.setAtk(20);
		a1.setDef(10);
		a1.setSpeed(30);
		armys1.add(a1);
		
		Army a2 = new Army();
		a2.setPid(1);
		a2.setPos(2);
		a2.setNum(100);
		a2.setAtk(20);
		a2.setDef(15);
		a2.setSpeed(45);
		armys1.add(a2);
		
		Army a3 = new Army();
		a3.setPid(1);
		a3.setPos(3);
		a3.setNum(100);
		a3.setAtk(20);
		a3.setDef(10);
		a3.setSpeed(55);
		armys1.add(a3);
		
		Army a4 = new Army();
		a4.setPid(1);
		a4.setPos(4);
		a4.setNum(100);
		a4.setAtk(20);
		a4.setDef(10);
		a4.setSpeed(44);
		armys1.add(a4);
		
		Army a5 = new Army();
		a5.setPid(1);
		a5.setPos(5);
		a5.setNum(100);
		a5.setAtk(20);
		a5.setDef(10);
		a5.setSpeed(65);
		armys1.add(a5);
		f1.setArmys(armys1);
		
		//===========================================
		
		Faction f2 = new Faction();
		f2.setSpeed(401);
		f1.setAttack(1600);
		f1.setAttackPlus(0.16);
		f1.setDefense(1400);
		f1.setDefensePlus(0.14);
		List<Army> armys2 = new ArrayList<Army>();
		Army b1 = new Army();
		b1.setPid(1);
		b1.setPos(1);
		b1.setNum(100);
		b1.setAtk(20);
		b1.setDef(10);
		b1.setSpeed(44);
		armys2.add(b1);
		
		Army b2 = new Army();
		b2.setPid(1);
		b2.setPos(2);
		b2.setNum(100);
		b2.setAtk(20);
		b2.setDef(10);
		b2.setSpeed(54);
		armys2.add(b2);
		
		Army b3 = new Army();
		b3.setPid(1);
		b3.setPos(3);
		b3.setNum(100);
		b3.setAtk(20);
		b3.setDef(10);
		b3.setSpeed(50);
		armys2.add(b3);
		
		Army b4 = new Army();
		b4.setPid(1);
		b4.setPos(4);
		b4.setNum(100);
		b4.setAtk(20);
		b4.setDef(10);
		b4.setSpeed(70);
		armys2.add(b4);
		
		Army b5 = new Army();
		b5.setPid(1);
		b5.setPos(5);
		b5.setNum(100);
		b5.setAtk(20);
		b5.setDef(10);
		b5.setSpeed(58);
		armys2.add(b5);
		f2.setArmys(armys2);
		
		WarService server = new WarService();
		StringBuffer report = server.war(f1, f2);
		Map ret = new HashMap();
		ret.put("report", report.toString());
		return ret;
		//System.out.println(report.toString());
	}
	
	/**
	 * log运算
	 * @param value
	 * @param base
	 * @return
	 */
	public static double log(int value,int base){
		return Math.log(value)/Math.log(base);
	}
}
