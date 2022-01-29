class Execute
{
	public static int count=0;
	public synchronized void operation1() throws Exception
	{
		for(int i=0;i<5;i++)
		{
			if(count%2!=0)
				this.wait();
			System.out.println(Thread.currentThread().getName() + " count = "+ count++);
			Thread.sleep(2000);
			this.notify();
		}
		
	}
	
	public synchronized void operation2()throws Exception
	{
		for(int i=0;i<5;i++)
		{
			if(count%2==0)
				this.wait();
			System.out.println(Thread.currentThread().getName() + " count = "+count++);
			Thread.sleep(2000);
			this.notify();
		}
	}
}


class MyThread7 extends Thread
{
	Execute e;
	public MyThread7(Execute obj)
	{
		super("Thread7");
		e=obj;
	}
	
	public void run()
	{
		try {
			e.operation2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyThread6 extends Thread
{
	Execute e;
	public MyThread6(Execute obj) 
	{
		super("Thread6");
		e=obj;
	}
	
	public void run()
	{
		try {
			e.operation1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class WaitNotifyDemo {

	public static void main(String[] args) {
		Execute e=new Execute();
		
		MyThread6 t1=new MyThread6(e);
		MyThread7 t2=new MyThread7(e);
		
		
		t1.start();
		t2.start();
	
		
		
		
	}

}
