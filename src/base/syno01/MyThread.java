package base.syno01;

/**
 * �̰߳�ȫ����:������̷߳���ĳһ����(����򷽷�)ʱ,�������ʼ�ն��ܱ��ֳ���������Ϊ,��ô�����(����򷽷�)�����̰߳�ȫ��
 * synchronized:������������󼰷����ϼ���,���������ֶδ����Ϊ"������"��"�ٽ���"
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
		 * ����:������̷߳���run()����ʱ,���Ŷӵķ�ʽ���д���
		 * 		һ���߳���Ҫִ��synchronized���εķ�����Ĵ���:
		 * 		1 ���Ի����
		 * 		2 ����õ���,ִ��synchronized����������;�ò���������߳̾ͻ᲻�ϵĳ��Ի����,ֱ����ȡ
		 * 		 ���ж���߳̾���һ����
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


