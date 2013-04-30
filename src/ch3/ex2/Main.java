package ch3.ex2;

public class Main {

	public static void main(String args[]) {
		PrintQueue printQueue = new PrintQueue();
		Thread thread[] = new Thread[3];
		for (int i = 0; i < 3; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread" + i);
		}
		for (int i = 0; i < 3; i++) {
			thread[i].start();
		}
	}
}
