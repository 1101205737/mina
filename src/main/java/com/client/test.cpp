//============================================================================
// Name        : test.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include "NetUtil.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

int main() {
	char* ret = sendMsg("CardAction#test");
	printf(ret);
	printf("\n");
	free(ret);
	string a;
	cin >> a;
	exit(0);
}
