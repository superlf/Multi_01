package base.syno04;

/**
 * 脏读问题
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
		System.out.println("设置完结果为:name="+name+",pass="+pass);
	}	
	
	// 测试sychronized
	public synchronized void getValue(){
		System.out.println("用户信息为:name="+this.name+",pass="+this.pass);
	}

	public static void main(String[] args) {
		
		DirtyRead dr = new DirtyRead();
		
		/*1、先对信息进行设置 */
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("wukong", "wukong");
			}
		});
		t1.start();
		
		/*2、对信息数据进行读取 */
		dr.getValue();
		

	}

}
