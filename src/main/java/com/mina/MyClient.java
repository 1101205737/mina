package com.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import securitytool.SecurityHelper;

class MyClient {

	public static void main(String[] args) throws IOException{
		
		IoConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new ByteArrayCodecFactory()));  
		connector.setHandler(new ClientHandler());
		IoSession session = null;
		ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 21));
		future.awaitUninterruptibly();
		session = future.getSession();
		Map params = new HashMap();
		
		params.put("_uid", SecurityHelper.encode32("1ad16116-1a69-49af-95e8-cc9bf8bb47cd".getBytes()));
		String loginKey = SecurityHelper.EncoderByMd5("1ad16116-1a69-49af-95e8-cc9bf8bb47cd" + "g78$*h&j%jsJ454f-L+ls2~@4");
		params.put("channel", "yh_ios_yy_002");
		params.put("ua", loginKey);
		params.put("isPay", "false");
		params.put("isuseMoney", "true");
		params.put("loginkey", loginKey);
		
		
		Map map = new HashMap();
		map.put("clazz", "LoginSvc");
		map.put("method", "login");
		map.put("params", params);
		map.put("uuid", 299);
		session.write(ByteUtil.objectToByte(map));
		//session.write("rr");
	}
}
