import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

class Display6 extends Thread
{
	static ReentrantLock l=new ReentrantLock(); //static object so that both threads have same object  
	public void run() 
	{
		try
		{
			do
			{
				if(l.tryLock(5,TimeUnit.SECONDS))
				{
					System.out.println(Thread.currentThread().getName() + "got the lock");
					Thread.sleep(20000);
					l.unlock();
					System.out.println(Thread.currentThread().getName() + "released the lock");
					break;
				}
				
				else
				{
					System.out.println(Thread.currentThread().getName() + "didnt get the lock");
				}
			}while(true);

		}
		catch(InterruptedException e) {}
	}
		
}


public class TryLockDemo 
{

	public static void main(String[] args)
	{
		Display6 d1=new Display6();
		Display6 d2=new Display6();
		
		d1.start();
		d2.start();
		

	}

}

