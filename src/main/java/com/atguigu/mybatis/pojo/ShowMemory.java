package com.atguigu.mybatis.pojo;

public class ShowMemory {
	
	public static void main(String[] args) {
		ShowMemory.showMemory();
	}
	
	public static void showMemory(){
		Runtime runtime = Runtime.getRuntime();
		int free = (int) runtime.freeMemory();
		int total = (int) runtime.totalMemory();
		System.out.println("free" + free + "total"+total);
	}

}
