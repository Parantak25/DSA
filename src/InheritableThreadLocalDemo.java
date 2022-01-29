class ParentThread extends Thread
{
	protected static InheritableThreadLocal tl=new InheritableThreadLocal()
			{
				public Object childValue(Object p)//overriding childValue method so that childclass has its separate value
				{
					return "CHILD";
				}
			};
			
	public void run()
	{
		tl.set("PARENT");
		System.out.println("PARENT THREAD VALUE: " + tl.get());
		ChildThread ct=new ChildThread();
		ct.start();
	}
}

class ChildThread extends Thread
{
	public void run()
	{
		System.out.println("CHILD THREAD VALUE: " + ParentThread.tl.get());
	}
}

public class InheritableThreadLocalDemo 
{

	public static void main(String[] args) 
	{
		ParentThread pt=new ParentThread();
		pt.start();
	}

}
