import java.util.concurrent.*;

class PrintJob implements Runnable
{
	String name;
	
	public PrintJob(String n)
	{
		name=n;
	}
	
	public void run()
	{
		System.err.println(Thread.currentThread().getName() + " is responsible for JOB:" + name);
		try {Thread.sleep(5000);} catch(InterruptedException e) {}
		System.err.println(Thread.currentThread().getName() + " has completed JOB:" + name);
	}
}

public class ExecutorDemo 
{

	public static void main(String[] args) 
	{
		PrintJob[] jobs= {new PrintJob("A"),new PrintJob("B"),
						  new PrintJob("C"),new PrintJob("D"),
						  new PrintJob("E"),new PrintJob("F")};
		
		ExecutorService service= Executors.newFixedThreadPool(3);//3 threads created
		
		for(PrintJob j:jobs)
		{
			service.submit(j); //3 threads will do 6 jobs
		}
		service.shutdown();
	}

}
