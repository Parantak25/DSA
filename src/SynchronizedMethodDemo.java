class Display
{
	public  void wish(String name)  //synchronized allows only one thread on a given object to execute at a time
	{
		for(int i=0;i<5;i++)
		{
			System.out.print("GOOD MORNING : ");
			try {Thread.sleep(2000);} catch(InterruptedException e) {}
			System.out.println(name);
		}

	}
}
	
class MyThreadSync extends Thread
{
	Display d;
	String name;
	MyThreadSync(Display d,String n) 
	{
		this.d=d;
		name=n;
	}
	
	public void run()
	{
		d.wish(name);
	}
}
	
public class SynchronizedMethodDemo 
{

	public static void main(String[] args) 
	{
		
		Display d=new Display();
		//Display d2=new Display();            
		MyThreadSync t1=new MyThreadSync(d,"PC");
		MyThreadSync t2=new MyThreadSync(d, "GAOTHI");
		//MyThreadSync t2=new MyThreadSync(d2, "GAOTHI");  //will give random o/p as object is not same;   
		
		t1.start();
		t2.start();

	}

}

