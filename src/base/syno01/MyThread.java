package base.syno01;

/**
 * 线程安全概念:当多个线程访问某一个类(对象或方法)时,这个对象始终都能表现出正常的行为,那么这个类(对象或方法)就是线程安全的
 * synchronized:可以在任意对象及方法上加锁,而加锁的字段代码称为"互斥区"或"临界区"
 * 
 * @author a-lin
 */

public class MyThread extends Thread{
	
	private int count = 5;
	
	public synchronized void run(){
		count --;
		System.out.println(this.currentThread().getName() +"count = "+count);
	}
	
	public static void main(String[] args) {
		/**
		 * 分析:当多个线程访问run()方法时,以排队的方式进行处理
		 * 		一个线程想要执行synchronized修饰的方法里的代码:
		 * 		1 尝试获得锁
		 * 		2 如果拿到锁,执行synchronized方法体内容;拿不到锁这个线程就会不断的尝试获得锁,直到获取
		 * 		 会有多个线程竞争一个锁
		 */
				
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt,"t1");
		Thread t2 = new Thread(mt,"t2");
		Thread t3 = new Thread(mt,"t3");
		Thread t4 = new Thread(mt,"t4");
		Thread t5 = new Thread(mt,"t5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
	}

}


