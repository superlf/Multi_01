package base.syno02;

/**
 * synchronized获取的都是对象锁，而不是把一段代码当作锁
 * 所以代码中哪个线程先执行synochronized关键字的方法，哪个线程就持有该方法所属对象的锁(Lock)
 * 
 * 在静态方法上加synchronized关键字，表示锁定class类(独占锁)
 * 
 * @author a-lin
 *
 */

public class MultiThread {
	
	public static int num = 0;
	
	public static synchronized void printNum(String tag){
		try {
			
			if(tag.equals("a")){
				num = 100;
				System.out.println("tag a,set num over!");
				Thread.sleep(1000);
			}else{
				num = 200;
				System.out.println("tag b,set num over!");
			}
			System.out.println("tag " + tag +" ,num = " + num);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
		
	//测试 run 方法输出顺序
	public static void main(String[] args) {
		
		MultiThread m1 = new MultiThread();
		MultiThread m2 = new MultiThread();
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				m1.printNum("a");
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				m1.printNum("b");
			}
		});
		
		
		t1.start();
		t2.start();
		

	}

}
