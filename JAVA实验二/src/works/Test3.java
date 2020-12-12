package works;

public class Test3 {
	public static void main(String args[]) {
		Station window1 = new Station("窗口1");
		Station window2 = new Station("窗口2");
		Station window3 = new Station("窗口3");
		window1.start();
		window2.start();
		window3.start();
	}
}

class Station extends Thread {
	static int ticket = 20;
	static Object ob="aa";
	Station(String name) {
		super(name);
	}
	@Override
	public void run() {
		while (ticket >= 0) {
			synchronized (ob) {
				if (ticket > 0) {
					System.out.println(getName() + "卖了第" + (ticket--) + "张票");
				} else {
					System.out.println("票卖完了");
					ticket--;
				}
			}
			try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}

	}
}
