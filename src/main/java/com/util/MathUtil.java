package com.util;

import java.util.Arrays;

/**
 * <h1>求最大公约数<h1><br>
 * 质因数分解法 <br>
 * 短除法 <br>
 * 辗转相除法 <br>
 * 更相减损法
 * 
 * @author yugi111
 */
public class MathUtil
{
	public static void main ( String[] args )
	{
		int[] numbers = { 124, 844, 4268 };
		try
		{
			System.out.println (Arrays.toString (numbers) + " 的最大公约数是：\n");
			System.out.println ("辗转相除法: " + euclidean (1, -1, -1, numbers));
			System.out.println ("更相减损法: " + derogateLaw (1, -1, -1, 0, numbers));
			System.out.println ("短除法: " + shortDivision (numbers));
		}
		catch (Exception e)
		{
			System.err.println (e.toString ());
			System.exit (-1);
		}
	}

	/**
	 * 辗转相除法：<br>
	 * <p>
	 * 求两个自然数(非负整数)的最大公约数的一种方法, 也叫欧几里德算法<br>
	 * <br>
	 * 用辗转相除法求几个数的最大公约数，可以先求出其中任意两个数的最大公约数，<br>
	 * 再求这个最大公约数与第三个数的最大公约数，依次求下去，直到最后一个数为止。<br>
	 * 最后所得的那个最大公约数，就是所有这些数的最大公约数
	 * 
	 * @param start
	 *            int 记录到第几个numbers里面的数字
	 * @param a
	 *            int 计算的第一个数字
	 * @param b
	 *            int 计算的第二个数字
	 * @param numbers
	 *            int... 包括待计算的数字的数组
	 * @throws Exception
	 *             参数不合法时抛出异常
	 */
	public static int euclidean ( int start, int a, int b, int... numbers ) throws Exception
	{
		int[] temp = isLegaled (a, b, numbers);
		a = temp[0];
		b = temp[1];
		int mod = a % b;
		if (mod == 0)
		{
			start++;
			if (start < numbers.length)
			{
				return euclidean (start, b, numbers[start], numbers);
			}
			else
			{
				return b;
			}
		}
		else
		{
			return euclidean (start, b, mod, numbers);
		}
	}

	/**
	 * <h1>短除法</h1> <br>
	 * 先用这几个数的公约数连续去除，一直除到所有的商互质为止, <br>
	 * 然后把所有的除数连乘起来，所得的积就是这几个数的最大公约数
	 * 
	 * @param numbers
	 *            int... 存放待计算的数字数组
	 * @return shortDivision int 返回重复计算的最大公约数
	 * @throws Exception
	 *             参数不够抛出异常
	 */
	public static int shortDivision ( int... numbers ) throws Exception
	{
		isLegaled (-1, -1, numbers);
		int[] cloned = Arrays.copyOf (numbers, numbers.length);
		Arrays.sort (cloned);
		for ( int i = 2; i <= cloned[0]; i++ )
		{
			boolean divisible = true;
			for ( int clone : cloned )
			{
				if (clone % i != 0)
				{
					divisible = false;
				}
			}
			if (divisible)
			{
				for ( int j = 0; j < cloned.length; j++ )
				{
					cloned[j] = cloned[j] / i;
				}
				return i * shortDivision (cloned);
			}
		}
		return 1;
	}

	/**
	 * <h1>更相减损法</h1><br>
	 * 第一步：任意给定两个正整数；判断它们是否都是偶数。若是，则用2约简；若不是则执行第二步。<br>
	 * 第二步：以较大的数减较小的数，接着把所得的差与较小的数比较，并以大数减小数。<br>
	 * 继续这个操作，直到所得的减数和差相等为止。 <br>
	 * 则第一步中约掉的若干个2与第二步中等数的乘积就是所求的最大公约数。
	 * 
	 * @param start
	 *            int 当前处理到了第几个数组里面的数字
	 * @param a
	 *            int 计算的第一个数
	 * @param b
	 *            int 计算的第二个数
	 * @param count
	 *            int 被计算出来的几个2
	 * @param numbers
	 *            int... 待计算的数字数组
	 * @return derogateLaw int 重复计算的最大公约数
	 * @throws Exception
	 *             参数非法抛出异常
	 */
	public static int derogateLaw ( int start, int a, int b, int count, int... numbers ) throws Exception
	{
		int[] temp = isLegaled (a, b, numbers);
		a = temp[0];
		b = temp[1];
		if (a % 2 == 0 && b % 2 == 0)
		{
			return derogateLaw (start, a >> 1, b >> 1, ++count, numbers);
		}
		if (a % 2 != 0 || b % 2 != 0)
		{
			int difference = -1;
			if (( difference = Math.abs (a - b) ) != a && difference != 0 && difference != b)
			{
				b = a > b ? b : a;
				a = difference;
				return derogateLaw (start, a, b, count, numbers);
			}
			else
			{
				start++;
				int moved = ( a = a > b ? b : a ) << count;
				if (start < numbers.length)
				{
					return derogateLaw (start, moved, numbers[start], 0, numbers);
				}
				else
				{
					return moved;
				}
			}
		}
		return 1;
	}

	private static int[] isLegaled ( int a, int b, int... numbers ) throws Exception
	{
		if (numbers.length < 2)
		{
			throw new Exception ("参数不够 ! ");
		}
		if (a == -1 && b == -1)
		{
			a = numbers[0];
			b = numbers[1];
		}
		String reg = "^\\+?\\d+$";
		if (!String.valueOf (b).matches (reg) || !String.valueOf (a).matches (reg))
		{
			throw new Exception ("相比较的两个数必须是: 非负整数 !");
		}
		return new int[] { a, b };
	}
}
