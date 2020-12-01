public class MultiThreaded {
	volatile int status = 0;

	public static void main(String[] args) {
		System.out.print("BEGIN");
		new MultiThreaded().evaluateInput();
		System.out.print("END");
	}

	public void evaluateInput() {
		int input;
		
		while (true) {
			try {
				input = System.in.read();
			} catch (Exception e) { input = 0; }

			switch(input) {
				case '1':
				case '2':
				case '3':
					status = input - '0';
					break;
				case 'q':
					return;
				default:
			}
		}
	}
} // class MultiThreaded