package ch3.ex2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

	private final Semaphore semaphore;
	private boolean freePrinters[];
	private Lock lockPrinters;
	
	public PrintQueue() {
		semaphore = new Semaphore(3);
		freePrinters= new boolean[3];
		for (int i = 0 ; i<3; i++){
			freePrinters[i]=true;
		}
		lockPrinters= new ReentrantLock();
	}

	public void printJob(Object document) {
		try {
			semaphore.acquire();
			int assignedPrinter = getPrinter();
			
			long duration = (long) (Math.random() * 10);
			System.out.printf(
					"%s: PrintQueue: Printing a Job during %d seconds\n",
					Thread.currentThread().getName(), duration);
			Thread.sleep(duration);
			freePrinters[assignedPrinter]=true;
		} catch (InterruptedException e) {
			System.out.println(
					"interrupted");
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	private int getPrinter(){
		int ret =-1 ;
		try {
			lockPrinters.lock();
			for (int i=0; i<freePrinters.length; i++){
				if (freePrinters[i]){
					ret = i;
					freePrinters[i]=false;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lockPrinters.unlock();
		}
		return ret;
	}
	
}
