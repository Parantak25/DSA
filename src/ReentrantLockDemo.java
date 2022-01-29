import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

 class Display5
{
	ReentrantLock l=new ReentrantLock();
	public void wish(String name)
	{
		l.lock();
		for(int i=0;i<5;i++)
		{
			System.out.print("HELLO ");
			try {Thread.sleep(2000);} catch(InterruptedException e) {}
			System.out.println(name);
		}
		l.unlock();
		
	}
}

class MyThreadR extends Thread
{
	Display5 d;
	String name;
	
	public MyThreadR(Display5 d,String name)
	{
		this.d=d;
		this.name=name;
	}
	
	public void run()
	{
		d.wish(name);
	}
		
}
 
public class ReentrantLockDemo 
{

	public static void main(String[] args) 
	{
		Display5 d=new Display5();
		MyThreadR t1=new MyThreadR(d,"PC");
		MyThreadR t2=new MyThreadR(d, "Modi");
		t1.start();
		t2.start();
	}

}
