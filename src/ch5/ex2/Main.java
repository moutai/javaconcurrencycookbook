package ch5.ex2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		Document mock = new Document();
		String[][] document = mock.generateDocument(100, 1000, "the");
		DocumentTask task = new DocumentTask(document, 0, 100, "the");
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n",
					pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n",
					pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			System.out.printf("******************************************\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
		pool.shutdown();
	}
}
