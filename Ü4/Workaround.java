import java.math.BigInteger;

class AddThread extends Thread {
	private int bound;
	private BigInteger result; // just to say that Threads aren't really the best ones

	AddThread(int bound) {
		this.bound = bound;
	}

	public void run() {
		BigInteger result = BigInteger.ZERO;
		for (int i = 1; i <= bound; i++) {
			result = result.add(BigInteger.valueOf(i));
		}
		this.result = result;
	}

	public BigInteger getResult() {
		return result;
	}
}

class MultiplyThread extends Thread {
	private int bound;
	private BigInteger result;

	MultiplyThread(int bound) {
		this.bound = bound;
	}

	public void run() {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= bound; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		this.result = result;
	}

	public BigInteger getResult() {
		return result;
	}
}

public class Workaround {
	public static void main(String args[]) {
		AddThread addThread = new AddThread(1000);
		MultiplyThread multThread = new MultiplyThread(1000);

		addThread.start();
		multThread.start();

		try {
			addThread.join(); // blockiert bis Thread beendet ist
			multThread.join(); // blockiert bis Thread beendet ist

			System.out.println("Ergebnis der Addition: " + addThread.getResult());

			System.out.println("Ergebnis der Multiplikation: " + multThread.getResult());
		} catch (InterruptedException e) {
		}
	}
}
