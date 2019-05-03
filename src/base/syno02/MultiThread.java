package base.syno02;

/**
 * synchronized��ȡ�Ķ��Ƕ������������ǰ�һ�δ��뵱����
 * ���Դ������ĸ��߳���ִ��synochronized�ؼ��ֵķ������ĸ��߳̾ͳ��и÷��������������(Lock)
 * 
 * �ھ�̬�����ϼ�synchronized�ؼ��֣���ʾ����class��(��ռ��)
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
		
		
	//���� run �������˳��
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
