package base.syno04;

/**
 * �������
 * @author a-lin
 */
public class DirtyRead {
	private String name = "super";
	private String pass = "super";
	
	public synchronized void setValue(String uname,String upass){
		this.name = uname;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.pass = upass;
		System.out.println("��������Ϊ:name="+name+",pass="+pass);
	}	
	
	// ����sychronized
	public synchronized void getValue(){
		System.out.println("�û���ϢΪ:name="+this.name+",pass="+this.pass);
	}

	public static void main(String[] args) {
		
		DirtyRead dr = new DirtyRead();
		
		/*1���ȶ���Ϣ�������� */
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("wukong", "wukong");
			}
		});
		t1.start();
		
		/*2������Ϣ���ݽ��ж�ȡ */
		dr.getValue();
		

	}

}
