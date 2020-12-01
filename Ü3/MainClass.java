class MainClass {
	public static void main(String[] args) {
		Thread a = new A("A");
		Thread b = new Thread(new B("B"));
		a.start();
		b.start();
	}
}

class A extends Thread {
	A(String name) {
		super(name);
	}
	
	public void run() {
		while (true) {
			System.out.print(getName());
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

class B implements Runnable {
	private String name;
	
	B(String name) {
		this.name = name;
	}
	
	public void run() {
		while (true) {
			System.out.print(name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}