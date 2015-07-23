package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Arithmatic {

	boolean flag = true;
	static int[][] map = new int[][]// 地图数组
	{
		{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
		{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0 },
		{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0 },
		{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
		{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
		{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	// 深度优先所使用的栈
	Stack<int[][]> stack = new Stack<int[][]>();
	HashMap<String, int[][]> hm = new HashMap<String, int[][]>();// 结果路径记录

	// TODO 出发点
	int[] source = { 2, 2 };
	// TODO 目标点
	int[] target = { 21, 22 };

	// 已经访问过的点
	int[][] visited = new int[map.length][map[0].length];// 0 未去过 1 去过
	// 当前点的八方
	int[][] sequence = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 },
			{ -1, -1 }, { 1, -1 }, { 1, 1 } };

	// 访问经过的路径总长度
	int count = 0;
	LinkedList<int[][]> queue = new LinkedList<int[][]>();
	// 记录到每个点的最短路径 for Dijkstra
	HashMap<String, ArrayList<int[][]>> hmPath = new HashMap<String, ArrayList<int[][]>>();
	// 记录路径长度 for Dijkstra
	int[][] length = new int[map.length][map[0].length];

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Arithmatic a = new Arithmatic();
		System.out.println("-----------深度优先搜索算法实现---------");
		a.DFS();
		System.out.println(a.count);

		int[] temp = a.target;
		while (true) {
			int[][] tempA = a.hm.get(temp[0] + ":" + temp[1]);
			System.out.println("(" + tempA[0][0] + "," + tempA[0][1] + ")"
					+ "--" + "(" + tempA[1][0] + "," + tempA[1][1] + ")");
			if (tempA[1][0] == a.source[0] && tempA[1][1] == a.source[1]) {// 判断有否到出发点
				break;
			}
			temp = tempA[1];
		}

		// for(int i = 0; i < a.stack.size(); i++){
		// System.out.println("(" + a.stack.get(i)[0][0] + "," +
		// a.stack.get(i)[0][1] + ")" + "--" + "(" + a.stack.get(i)[1][0] + ","
		// + a.stack.get(i)[1][1] + ")");
		// }
		a.visited = new int[map.length][map[0].length];
		System.out.println("-----------广度优先搜索算法实现---------");
		a.BFS();
		System.out.println(a.count);
		temp = a.target;
		while (true) {
			int[][] tempA = a.hm.get(temp[0] + ":" + temp[1]);
			System.out.println("(" + tempA[0][0] + "," + tempA[0][1] + ")"
					+ "--" + "(" + tempA[1][0] + "," + tempA[1][1] + ")");
			if (tempA[1][0] == a.source[0] && tempA[1][1] == a.source[1]) {// 判断有否到出发点
				break;
			}
			temp = tempA[1];
		}
		// for(int i = 0; i < a.queue.size(); i++){
		// System.out.println("(" + a.queue.get(i)[0][0] + "," +
		// a.queue.get(i)[0][1] + ")" + "--" + "(" + a.queue.get(i)[1][0] + ","
		// + a.queue.get(i)[1][1] + ")");
		// }

		// a.visited=new int[map.length][map[0].length];
		// System.out.println("----------Dijkstra算法实现--------------");
		// a.Dijkstra();
		// System.out.println(a.count);
		// ArrayList<int[][]> alPath=a.hmPath.get(a.target[0]+":"+a.target[1]);
		// for(int[][] t: alPath){
		// System.out.println("(" + t[0][0] + "," + t[0][1] + ")" + "--" + "(" +
		// t[1][0] + "," + t[1][1] + ")");
		// }

	}

	/**
	 * 深度优先搜索算法
	 */
	public void DFS() {
		// 开始路径
		int[][] start = { { source[0], source[1] }, { source[0], source[1] } };
		stack.push(start);
		while (flag) {
			int[][] currentEdge = stack.pop();// 从栈顶取出边
			int[] tempTarget = currentEdge[1];// 取出此边的目的点
			// 判断目的点是否去过，若去过则直接进入下次循环
			if (visited[tempTarget[1]][tempTarget[0]] == 1) {
				continue;
			}
			count++;
			visited[tempTarget[1]][tempTarget[0]] = 1;// 标识目的点为访问过
			// 记录此临时目的点的父节点
			hm.put(tempTarget[0] + ":" + tempTarget[1], new int[][] {
					currentEdge[1], currentEdge[0] });
			// 判断有否找到目的点
			if (tempTarget[0] == target[0] && tempTarget[1] == target[1]) {
				break;
			}
			// 将所有可能的边入栈
			int currCol = tempTarget[0];
			int currRow = tempTarget[1];
			// 将它的周围相连点都加入到栈中
			for (int[] rc : sequence) {
				int i = rc[1];
				int j = rc[0];
				if (i == 0 && j == 0) {
					continue;
				}
				if (currRow + i >= 0 && currRow + i < map.length
						&& currCol + j >= 0 && currCol + j < map[0].length
						&& map[currRow + i][currCol + j] != 1) {
					// 将此边入栈
					int[][] tempEdge = { { tempTarget[0], tempTarget[1] },
							{ currCol + j, currRow + i } };
					stack.push(tempEdge);
				}
			}
		}
	}

	/**
	 * 深度优先算法
	 */
	public void BFS() {
		count = 0;
		hm.clear();

		// 开始路径
		int[][] start = { { source[0], source[1] }, { source[0], source[1] } };
		queue.offer(start);
		while (flag) {
			int[][] currentEdge = queue.poll();// 从队首取出边
			int[] tempTarget = currentEdge[1];// 取出此边的目的点
			// 判断目的点是否去过，若去过则直接进入下次循环
			if (visited[tempTarget[1]][tempTarget[0]] == 1) {
				continue;
			}
			count++;
			visited[tempTarget[1]][tempTarget[0]] = 1;// 标识目的点为访问过
			// 记录此临时目的点的父节点
			hm.put(tempTarget[0] + ":" + tempTarget[1], new int[][] {
					currentEdge[1], currentEdge[0] });
			// 判断有否找到目的点
			if (tempTarget[0] == target[0] && tempTarget[1] == target[1]) {
				break;
			}
			// 将所有可能的边入队列
			int currCol = tempTarget[0];
			int currRow = tempTarget[1];
			for (int[] rc : sequence) {
				int i = rc[1];
				int j = rc[0];
				if (i == 0 && j == 0) {
					continue;
				}
				if (currRow + i >= 0 && currRow + i < map.length
						&& currCol + j >= 0 && currCol + j < map[0].length
						&& map[currRow + i][currCol + j] != 1) {
					int[][] tempEdge = { { tempTarget[0], tempTarget[1] },
							{ currCol + j, currRow + i } };
					queue.offer(tempEdge);
				}
			}
		}
	}

	// =========================================================

}
