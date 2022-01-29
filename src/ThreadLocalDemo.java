
class CustomerThread extends Thread
{
	static Integer custID=0;
	private static ThreadLocal tl=new ThreadLocal()
			{
				   
				protected synchronized Integer initialValue()
				{
					return ++custID;
				}
			};
			
	public CustomerThread(String name) 
	{
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " is executing order of customer " + tl.get());
	}
}

public class ThreadLocalDemo {

	public static void main(String[] args) 
	{
		CustomerThread c1=new CustomerThread("A");
		CustomerThread c2=new CustomerThread("B");
		CustomerThread c3=new CustomerThread("C");
		CustomerThread c4=new CustomerThread("D");
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		
	}

}
