package com.cast.vtiger.genericUtility;

import java.util.Random;

public class Java_utility {
public int getRandomNum() {
	Random  ran = new Random();
	int Ranno = ran.nextInt(1000);
	return Ranno;
	
}
	
}
