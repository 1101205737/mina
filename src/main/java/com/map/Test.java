package com.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {
	
	int[][] map =
	{
		{1,0,0,0,0,0,0,0,0},
		{1,1,0,0,0,0,0,0,0},
		{0,1,1,0,0,0,0,0,0},
		{0,0,1,0,0,1,1,1,0},
		{0,0,1,1,1,1,0,1,0},
		{0,0,0,0,0,0,0,1,1}
	};
	
	int[][] visitide = new int[map.length][map[0].length];

	int[] start = {0,0};
	int[] end = {5,8};
	int[][] quence = {{1,0},{0,1},{-1,0},{0,-1}};
	Stack<int[][]> stack = new Stack<int[][]>();//当前和下一个
	Map<String,int[][]> hm = new HashMap<String,int[][]>();
	
	int count = 0;
	
	public static void main(String[] args){
		Test t = new Test();
		t.test();
		System.out.println(t.count);
	}
	
	public void test(){
		stack.push(new int[][]{start,start});
		while(true){
			int[][] temp = stack.pop();
			int[] tempB = temp[1];
			if(visitide[tempB[0]][tempB[1]] == 1){
				continue;
			}
			count++;
			visitide[tempB[0]][tempB[1]] = 1;
			hm.put(tempB[0]+":"+tempB[1], new int[][]{temp[0],temp[1]});
			
			if(tempB[0] == end[0] && tempB[1] == end[1])
				break;
			
			System.out.println("target:"+tempB[0]+"--"+tempB[1]);
			for(int[] n : quence){
				System.out.println((tempB[0]+n[0])+"---"+(tempB[1]+n[1]));
				if(tempB[0]+n[0]>=0 && tempB[0]+n[0] <=5 && tempB[1]+n[1]>=0 && tempB[1]+n[1] <=8  && map[tempB[0]+n[0]][tempB[1]+n[1]]==1){
					if(visitide[tempB[0]+n[0]][tempB[1]+n[1]] == 1){
						continue;
					}
					stack.push(new int[][]{tempB,{tempB[0]+n[0],tempB[1]+n[1]}});
					System.out.println("success:" + (tempB[0]+n[0])+"---"+(tempB[1]+n[1]));
				}
			}
		}
	}
}
