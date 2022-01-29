//To access a static synchronized method the thread requires the class level lock

class Display3
{
	public static synchronized void numbers()
	{
		for(int i=0;i<5;i++)
		{
			System.out.print(i + " ");
			try {Thread.sleep(1000); } catch(InterruptedException e) {};
		}
	}
	
	public static synchronized void characters()
	{
		for(int i=65;i<70;i++)
		{
			System.out.print((char)i + " " );
			try {Thread.sleep(1000); } catch(InterruptedException e) {};
		}
	}
	
	public synchronized void print()
	{
		System.out.println("HEHE  LOL");
	}
}



class MyThread3a extends Thread
{
	Display3 d;
	
	MyThread3a(Display3 d)
	{
		this.d=d;
	}
	
	public void run()
	{
		d.characters();
	}
}

class MyThread3b extends Thread
{
	Display3 d;
	
	MyThread3b(Display3 d)
	{
		this.d=d;
	}
	
	public void run()
	{
		d.numbers();
	}
}

class MyThread3c extends Thread
{
	Display3 d;
	
	MyThread3c(Display3 d)
	{
		this.d=d;
	}
	
	public void run()
	{
		d.characters();
	}
}

public class ClassLevelLockDemo {

	public static void main(String[] args) {
		Display3 d1=new Display3();
		Display3 d2=new Display3();
		Display3 d3=new Display3();
		
		MyThread3a t1=new MyThread3a(d1);
		MyThread3b t2=new MyThread3b(d2);
		MyThread3c t3=new MyThread3c(d3);
		
		//remove static from characters and :
//		MyThread3a t1=new MyThread3a(d1);
//		MyThread3b t2=new MyThread3b(d2);
//		MyThread3c t3=new MyThread3c(d1);
		//t1 and t2 have same object and will call character(), hence static is not required.
		
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
