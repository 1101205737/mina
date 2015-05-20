/*
 * NetUtil.cpp
 *
 *  Created on: 2015年5月20日
 *      Author: dell
 */

//============================================================================
// Name        : test.cpp
// Author      :
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include "NetUtil.h"

#define MINGW32

#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <map>

using namespace std;

#ifdef MINGW32
#include <winsock2.h>
#else
//#include <sys/socket.h>
//#include <arpa/inet.h>
#endif

#define MAXLINE 1024

char* sendMsg(char* para) {
	int sockfd, n;
	char size[4];
	struct sockaddr_in serveraddr;

#ifdef MINGW32
	//Winsows下启用socket
	WSADATA wsadata;
	if (WSAStartup(MAKEWORD(1,1), &wsadata) == SOCKET_ERROR) {
		printf("WSAStartup() fail\n");
		exit(0);
	}
#endif
	//建立socket
	if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
		printf("socket() fail\n");
		exit(0);
	}

	//设置协议及Port
	memset(&serveraddr, 0, sizeof(serveraddr));
	serveraddr.sin_family = AF_INET;
	serveraddr.sin_port = htons(8888);

	//设置IP
	serveraddr.sin_addr.s_addr = inet_addr("192.168.82.62");

	//连接
	if (connect(sockfd, (struct sockaddr *) &serveraddr, sizeof(serveraddr))
			== -1) {
		printf("connect() fail\n");
		exit(0);
	}

	//读取数据并输入到标准输出
#ifdef MINGW32
	//send(SOCKET,const char*,int,int);

	send(sockfd,para,strlen(para),0);


	recv(sockfd,size,4,0);
	int ss = byteToInt(size);

	printf("packet_size: %d\n",ss);

	if(ss < 1)
		return NULL;

	//char receline[ss + 1];
	char *receline=(char*)malloc(ss + 1);

	while ((n = recv(sockfd, receline, ss, 0)) > 0)
#else
	while((n=read(sockfd,receline,ss))>0)
#endif
	{
		receline[n] = 0;
//		if (fputs(receline, stdout) == EOF) {
//			printf("fputs() error\r\n");
//		}
	}
	//没有获取数据
	if (n < 0) {
		printf("read() fail\n");
	}

#ifdef MINGW32
	//Winsows下关闭socket
	closesocket(sockfd);
	WSACleanup();
#endif
	return receline;
}


int byteToInt(char b[]){
	int a1 = b[0] & 0xff;
	int a2 = b[1] & 0xff;
	int a3 = b[2] & 0xff;
	int a4 = b[3] & 0xff;
	a4 = a4 <<24;
	a3 = a3 <<16;
	a2 = a2 <<8;
	return a4|a3|a2|a1;
}
