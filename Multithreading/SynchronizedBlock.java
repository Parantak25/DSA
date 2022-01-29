

class Display4
{
	public static void numbers()
	{
		synchronized (Display4.class)
		{
			for(int i=0;i<5;i++)
			{
				System.out.print(i + " ");
				try {Thread.sleep(1000); } catch(InterruptedException e) {};
			}
		}
		
	}
	
	public static  void characters()
	{
		synchronized (Display4.class) 
		{
			for(int i=65;i<70;i++)
			{
				System.out.print((char)i + " " );
				try {Thread.sleep(1000); } catch(InterruptedException e) {};
			}
		}
		
	}
	
	public synchronized void print()
	{
		System.out.println("HEHE  LOL");
	}
}



class MyThread4a extends Thread
{
	Display4 d;
	
	MyThread4a(Display4 d)
	{
		this.d=d;
	}
	
	public void run()
	{
		d.characters();
	}
}

class MyThread4b extends Thread
{
	Display4 d;
	
	MyThread4b(Display4 d)
	{
		this.d=d;
	}
	
	public void run()
	{
		d.numbers();
	}
}

class MyThread4c extends Thread
{
	Display4 d;
	
	MyThread4c(Display4 d)
	{
		this.d=d;
	}
	
	public void run()
	{
		d.characters();
	}
}

public class SynchronizedBlock  {

	public static void main(String[] args) {
		Display4 d1=new Display4();
		Display4 d2=new Display4();
		Display4 d3=new Display4();
		
		MyThread4a t1=new MyThread4a(d1);
		MyThread4b t2=new MyThread4b(d2);
		MyThread4c t3=new MyThread4c(d3);
		

		
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
