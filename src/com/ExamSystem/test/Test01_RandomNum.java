package com.ExamSystem.test;

import java.util.Arrays;

public class Test01_RandomNum {
	public static void main(String[] args) {
		int[] indexs = new int[2];
		int index1 = (int)(Math.random()*6);
		int index2 = index1;
		while(true) {
			index2 = (int)(Math.random()*6);
			if(index2 != index1) {
				break;
			}
		}
		indexs[0] = index1;
		indexs[1] = index2;
		
		System.out.println(Arrays.toString(indexs));
	}		
}
