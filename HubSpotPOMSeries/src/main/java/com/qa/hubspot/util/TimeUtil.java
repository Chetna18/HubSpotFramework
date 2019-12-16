package com.qa.hubspot.util;

public class TimeUtil {
	
	public static void shortwait(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void mediumwait(){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void longwait(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
