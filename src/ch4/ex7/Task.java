package ch4.ex7;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Runnable {
	private String name;

	public Task(String name) {
		this.name = name;
	}

	// @Override
	// public String call() throws Exception {
	// System.out.printf("%s: Starting at : %s\n",name,new Date());
	// return "Hello, world";
	// }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 System.out.printf("%s: Starting at : %s\n",name,new Date());
	}
}
