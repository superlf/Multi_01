package base.syno03;
/**
 * 对象锁的同步异步问题
 * @author a-lin
 */

public class MyObject {
	
	public synchronized void method1(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void method2(){
		System.out.println(Thread.currentThread().getName());
	}

	
	
	public static void main(String[] args) {
		
		final MyObject mo = new MyObject();
		/**
		 * 分析:
		 * t1线程先持有Object对象的Lock锁,t2线程如果调用对象中的synchronized修饰的方法需要等待(同步)
		 * t1线程先持有Object对象的Lock锁,t2线程可以异步的方式调用对象中的非synchronized的方法(异步)
		 * 
		 */
		
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo.method1();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo.method1();
			}
		},"t2");
		
		t1.start();
		t2.start();
		

	}

}
