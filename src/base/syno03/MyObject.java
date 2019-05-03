package base.syno03;
/**
 * ��������ͬ���첽����
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
		 * ����:
		 * t1�߳��ȳ���Object�����Lock��,t2�߳�������ö����е�synchronized���εķ�����Ҫ�ȴ�(ͬ��)
		 * t1�߳��ȳ���Object�����Lock��,t2�߳̿����첽�ķ�ʽ���ö����еķ�synchronized�ķ���(�첽)
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
