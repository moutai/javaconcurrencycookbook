package ch4.ex8;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	private String name;

	public Task(String name) {
		this.name = name;
	}

	public Task() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		 while (true){
		      System.out.printf("Task: Test\n");
		      Thread.sleep(100);
		    }
	}

}
