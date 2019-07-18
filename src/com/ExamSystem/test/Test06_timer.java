package com.ExamSystem.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Test06_timer {
	public static void main(String[] args) {
		Thread timer = new Thread(new Runnable() {
			int time = 60*60;
			
			
			@Override
			public void run() {
				while(true) { 
					time --;
					try {
						Thread.sleep(1000);
						int hh = time / 60 / 60 % 60;
						int mm = time / 60 % 60;
						int ss = time % 60;
						
						System.out.println(hh + ":" + mm + ":" + ss);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		timer.start();
	}
}
