import java.util.concurrent.*;

class MyCallable implements Callable<Integer>
{
	int num;
	public MyCallable(int n)
	{
		num=n;
	}
	
	public Integer call() throws Exception
	{
		System.out.println(Thread.currentThread().getName() + " is responsible for finding the sum of first " + num + " numbers");
		int sum=0;
		for(int i=0;i<=num;i++)
			sum=sum+i;
		return sum;
	}
}

public class CallableDemo 
{

	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		MyCallable[] jobs= {new MyCallable(10),new MyCallable(20),
					    	new MyCallable(30),new MyCallable(30),
					    	new MyCallable(40),new MyCallable(50),
					    	new MyCallable(60)};
		
		ExecutorService service=Executors.newFixedThreadPool(3);
		
		for(MyCallable j:jobs)
		{
			Future<Integer> f=service.submit(j);
			System.out.println(f.get());
		}
		
		service.shutdown();

	}

}
