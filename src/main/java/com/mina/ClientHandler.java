package com.mina;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ClientHandler implements IoHandler{

	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("exceptionCaught");
		arg1.printStackTrace();
	}

	public void messageReceived(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("messageReceived");
		System.out.println(arg1.toString());
	}

	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("messageSent");
	}

	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sessionClosed");
	}

	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sessionCreated");
	}

	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sessionIdle");
	}

	public void sessionOpened(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sessionOpened");
	}

}
