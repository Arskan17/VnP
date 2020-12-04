import java.math.BigInteger;
import java.util.concurrent.*;

class AddCallable implements Callable<BigInteger> {
	private int bound;

	AddCallable(int bound) {
		this.bound = bound;
	}

	public BigInteger call() {
		BigInteger result = BigInteger.ZERO;
		for (int i = 1; i <= bound; i++) {
			result = result.add(BigInteger.valueOf(i));
		}
		return result;
	}
}

class MultiplyCallable implements Callable<BigInteger> {
	private int bound;

	MultiplyCallable(int bound) {
		this.bound = bound;
	}

	public BigInteger call() {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= bound; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}

public class CallableDemo {
	public static void main(String args[]) {
		Callable<BigInteger> addCallable = new AddCallable(1000);
		Callable<BigInteger> multCallable = new MultiplyCallable(1000);

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Future<BigInteger> resultAdd = executor.submit(addCallable);
		Future<BigInteger> resultMult = executor.submit(multCallable);

		try {
			BigInteger addRes = resultAdd.get(); // blockiert, bis Ergbnis vorliegt
			System.out.println("Ergebnis der Addition: " + addRes);

			BigInteger multRes = resultMult.get(); // blockiert, bis Ergbnis vorliegt
			System.out.println("Ergebnis der Multiplikation: " + multRes);
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}
		executor.shutdown();
	}
}
