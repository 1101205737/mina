//============================================================================
// Name        : test.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

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

int main() {
	int sockfd, n;
	char receline[MAXLINE + 1];
	struct sockaddr_in serveraddr;

#ifdef MINGW32
	//Winsows������socket
	WSADATA wsadata;
	if (WSAStartup(MAKEWORD(1,1), &wsadata) == SOCKET_ERROR) {
		printf("WSAStartup() fail\n");
		exit(0);
	}
#endif
	//����socket
	if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
		printf("socket() fail\n");
		exit(0);
	}

	//����Э�鼰Port
	memset(&serveraddr, 0, sizeof(serveraddr));
	serveraddr.sin_family = AF_INET;
	serveraddr.sin_port = htons(8888);

	//����IP
	serveraddr.sin_addr.s_addr = inet_addr("127.0.0.1");

	//����
	if (connect(sockfd, (struct sockaddr *) &serveraddr, sizeof(serveraddr))
			== -1) {
		printf("connect() fail\n");
		exit(0);
	}

	//��ȡ���ݲ����뵽��׼���
#ifdef MINGW32
	//send(SOCKET,const char*,int,int);
	send(sockfd,"abcd",4,0);
	while ((n = recv(sockfd, receline, MAXLINE, 0)) > 0)
#else
	while((n=read(sockfd,receline,MAXLINE))>0)
#endif
	{
		receline[n] = 0;
		if (fputs(receline, stdout) == EOF) {
			printf("fputs() error\r\n");
		}
	}

	//û�л�ȡ����
	if (n < 0) {
		printf("read() fail\n");
	}

#ifdef MINGW32
	//Winsows�¹ر�socket
	closesocket(sockfd);
	WSACleanup();
#endif

	exit(0);
}
