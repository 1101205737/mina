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
		
//		params.put("uid", "6180ae64-96e0-4e25-a116-42cd6d4a2d93");
//		params.put("gidx", 16218);
//		Map map = new HashMap();
//		map.put("clazz", "HoleSvc");
//		map.put("method", "getHoleInitInfo");
//		map.put("params", params);
//		map.put("uuid", 299);
//		session.write(ByteUtil.objectToByte(map));
		
//		params.put("uid", "6180ae64-96e0-4e25-a116-42cd6d4a2d93");
//		params.put("exchangeId", 1017);
//		Map map = new HashMap();
//		map.put("clazz", "HoleSvc");
//		map.put("method", "exchange");
//		map.put("params", params);
//		map.put("uuid", 299);
//		session.write(ByteUtil.objectToByte(map));
		
		
//		params.put("uid", "6180ae64-96e0-4e25-a116-42cd6d4a2d93");
//		params.put("gidx", 16218);
//		Map map = new HashMap();
//		map.put("clazz", "HoleSvc");
//		map.put("method", "beginHole");
//		map.put("params", params);
//		map.put("uuid", 299);
//		session.write(ByteUtil.objectToByte(map));
		
		
//		params.put("uid", "6180ae64-96e0-4e25-a116-42cd6d4a2d93");
//		params.put("exchangeId", 1017);
		Map map = new HashMap();
		map.put("clazz", "HoleSvc");
		map.put("method", "stop");
		map.put("params", params);
		map.put("uuid", 299);
		session.write(ByteUtil.objectToByte(map));
		
		
	}
}
