package com.ExamSystem.test;

import java.util.Arrays;

public class Test05_IntegerToInt {
	public static void main(String[] args) {
		Integer[] a = new Integer[] {1,2,3};
		int[] b = new int[] {3,2,1};
		int[] c = new int[] {1,2,3};
		Arrays.sort(a);
		Arrays.sort(b);
		if(Arrays.equals(c, b)) {
			System.out.println("一致");
		}else {
			System.out.println("不同");
		}
		
	}
}
