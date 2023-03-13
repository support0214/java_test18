package thread;

public class Thread1 {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		// thread1.test1();
		// thread1.test2();
		// thread1.test3();
		thread1.test4();
		System.out.println(Thread.currentThread().getName()+"End");
	}
	
	private void test1() {
		a("#");
		b("^");
	}
	
	private void test2() {
		Thread th1 = new MyThread1();
		Thread th2 = new MyThread2();
		th1.start();
		th2.start();
	}
	
	// 하나의 쓰레드 클래스로 여러 쓰레드 만들기
	private void test3() {
		Thread th1 = new Thread(new Foo("&"));
		Thread th2 = new Thread(new Foo("*"));
		// th1.start();
		// th2.start();
		
		String[] arr = {"!","@","#","$","%","^","&","*","+"};
		for(int i = 0; i<arr.length; i++) {
			new Thread(new Foo(arr[i])).start();
		}

	}
	
	/*
	 * 쓰레드 스케줄링
	 * - OS 스케줄링 따라 임의의 순서가 부여됨
	 * - 우선순위 (1~10)
	 * 	- 10 : Thread.MAX_PRIORITY
	 *  - 5 : Thread.NORM_PRIORITY (순위를 넣지않으면 기본값)
	 *  - 1 : Thread.MIN_PRIORITY
	 */
	private void test4() {
		Thread th1 = new Thread(new Foo("O"));
		Thread th2 = new Thread(new Foo("X"));
		
		th1.setPriority(3);
		th2.setPriority(Thread.MAX_PRIORITY);
		
		th1.start();
		th2.start();
	}
	
	// 2. 쓰레드 클래스 만들기
		//  implements runable 사용 : run 오버라이딩
	
	class Foo implements Runnable {
		private String str;

		public Foo(String str) {
			this.str = str;
		}
		
		@Override
		public void run() {
			for(int i =0; i<300; i++)
				System.out.print(str); // String str을 입력
		}
	}
	
	// 1. 쓰레드 클래스 만들기
		//  Thread상속 : run 오버라이딩
	class MyThread1 extends Thread {
		@Override
		public void run() {
			a("#");
		}
	}  
	
	class MyThread2 extends Thread {
		@Override
		public void run() {
			b("^");
		}
	}

	
	public void a(String str) {
		for(int i =0; i<300; i++)
			System.out.print(str);
	}
	
	public void b(String str) {
		for(int i =0; i<300; i++)
			System.out.print(str);
	}
}
