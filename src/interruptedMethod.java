
class MyThread2 extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("CHILD THREAD");
		}
		
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			System.out.println("CHILD THREAD INTERRUPTED");
		}
		
	}
}

public class interruptedMethod {

	public static void main(String[] args) throws Exception {
		MyThread2 t=new MyThread2();
		t.start();
		t.interrupt();
		
		System.out.println("Main thread");
	}

}
