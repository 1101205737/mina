package com.proxy;

import java.lang.reflect.Proxy;

public class Xss {

	public static void main(String[] args){
		ITest m = new Test();
		MyInvocationHandler h = new MyInvocationHandler(m);
		ITest t = (ITest) Proxy.newProxyInstance(m.getClass().getClassLoader(), m.getClass().getInterfaces(), h);
		t.test();
	}
}
