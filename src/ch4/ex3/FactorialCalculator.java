package ch4.ex3;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {

	private Integer num;

	public FactorialCalculator(Integer num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		int result = 1;
		if ((num == 0) || (num == 1)) {
			result = 1;
		} else {
			for (int i = 2; i <= num; i++) {
				result *= i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		System.out.printf("%s: %d\n",Thread.currentThread().getName());
		return result;
	}
}
