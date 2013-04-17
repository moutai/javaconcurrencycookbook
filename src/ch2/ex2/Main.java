package ch2.ex2;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cinema cinema=new Cinema();
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1,"TicketOffice1");
		
		TicketOffice1 ticketOffice2 = new TicketOffice1(cinema);
		Thread thread2 = new Thread(ticketOffice1,"TicketOffice2");
		
		thread1.start();
	    thread2.start();
	    
	    try {
	        thread1.join();
	        thread2.join();
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    
	    System.out.printf("Room 1 Vacancies: %d\n",cinema.getVacanciesCinema1());
	    System.out.printf("Room 2 Vacancies: %d\n",cinema.getVacanciesCinema2());
	}

}
