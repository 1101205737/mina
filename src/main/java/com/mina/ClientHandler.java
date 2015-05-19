package com.mina;

import java.util.Map;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.util.ProxyUtil;

public class ClientHandler implements IoHandler{
	private String _class;
	private String callback;
	
	public ClientHandler(){
		
	}
	
	public ClientHandler(String _class,String callback){
		this._class = _class;
		this.callback = callback;
	}

	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		System.out.println("exceptionCaught");
		arg1.printStackTrace();
	}

	public void messageReceived(IoSession session, Object arg1) throws Exception {
		if(arg1 instanceof byte[]){
			Map map = (Map) ByteUtil.byteToObject((byte[])arg1);
			ProxyUtil.invoke(_class, callback, map);
			session.close();
		}
	}

	public void messageSent(IoSession arg0, Object arg1) throws Exception {
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
