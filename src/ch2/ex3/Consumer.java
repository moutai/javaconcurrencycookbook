package ch2.ex3;

public class Consumer implements Runnable{

	private EventStorage storage;
	public Consumer(EventStorage storage){
		this.storage = storage;
	}
	@Override
	public void run(){
		for (int i =0 ; i<100 ; i++){
			System.out.println("Producer:"+i);
			storage.get();
		}
	}
}
