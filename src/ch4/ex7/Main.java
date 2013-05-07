package ch4.ex7;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(1);
		System.out.printf("Main: Starting at: %s\n", new Date());
		Task task = new Task("Task");
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2,
				TimeUnit.SECONDS);

		for (int i = 0; i < 10; i++) {
			System.out.printf("Main: Delay: %d\n",
					result.getDelay(TimeUnit.MILLISECONDS));
			// Sleep the thread during 500 milliseconds.
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Finished at: %s\n", new Date());

	}
}
