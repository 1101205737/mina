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
		ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 8888));
		future.awaitUninterruptibly();
		session = future.getSession();

		Map map = new HashMap();
		map.put("class", "CardAction");
		map.put("method", "extract");
		session.write(ByteUtil.objectToByte(map));
		
		
	}
}
