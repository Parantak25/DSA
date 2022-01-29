class Counter
{
	int count=0;
	
	public synchronized void increment()  //synchronized : takes care that only one thread is executing at a time
	{
		count++;
	}
}

public class Synchronize {

	public static void main(String[] args)throws Exception {
	 
			Counter c=new Counter();
			
			Thread t1=new Thread(new Runnable()
					{
						public void run()
						{
							for(int i=0;i<1000;i++)
								c.increment();
						}
					});
			
			Thread t2=new Thread(new Runnable()
					{
						public void run()
						{
							for(int i=0;i<1000;i++)
								c.increment();
						}
					});
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
			System.out.println(c.count);

	}

}
