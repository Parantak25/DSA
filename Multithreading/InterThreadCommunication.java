class commDemo
{
	
	boolean valueSet=false;
	
	public synchronized void put(int num)
	{
		while(valueSet)
			try {wait();} catch(Exception e) {}; //wait
			
		System.out.println("put : " + num);
		
		valueSet =true;
		notify();
	}
	
	public synchronized void get(int num)
	{
		while(!valueSet)
			try {wait();} catch(Exception e) {};
			
		System.out.println("get : " + num);
		
		valueSet =false;
		notify();
	}
}

class Producer implements Runnable
{
	commDemo d;
	Producer(commDemo cd)
	{
		d=cd;
		Thread t=new Thread(this,"producer");
		t.start();  //run function of runnable called
	}
	
	public void run()
	{
		int i=0;
		while(true)
		{
			d.put(i++);
			try {Thread.sleep(2000);} catch(Exception e) {};
		}
	}
	
}

class Consumer implements Runnable
{
	commDemo d;
	Consumer(commDemo cd)
	{
		d=cd;
		Thread t=new Thread(this,"consumer");
		t.start();
	}
	
	public void run()
	{
		int i=0;
		while(true)
		{
			d.get(i++);
			try {Thread.sleep(5000);} catch(Exception e) {};
		}
	}
	
}


public class InterThreadCommunication {

	public static void main(String[] args) {
			commDemo cd=new commDemo();
			new Producer(cd);
			new Consumer(cd);

	}

}
