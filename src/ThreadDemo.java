class Hi implements Runnable
{
	@Override
	public void run() {
		
		for(int i=0;i<5;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("Hi " + Thread.currentThread().getPriority()	);
		}
			
	}
}

class Hello implements Runnable
{
	@Override
	public void run() {
		
		for(int i=0;i<5;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			System.out.println("Hello " + Thread.currentThread().getPriority());
		}
	}
}


public class ThreadDemo {

	public static void main(String[] args) throws Exception {
		
		Runnable o1=new Hi();
		Runnable o2=new Hello();
		
		Thread t1=new Thread(o1);  //run() of runnable object "o1" will be called when thread t1 will start.
		Thread t2=new Thread(o2);
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();                //run() of o1 will be called.
		
		System.out.println(t1.isAlive());  //checks whether the thread is in working state
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		t2.start();
		t1.join();       //Waits for the thread to die
		t2.join(); 
		System.out.println("heelo");

	}

}


//USING LAMBDA EXPRESSION

//public class ThreadDemo {
//
//	public static void main(String[] args) {	
//		Thread t1=new Thread(() -> {
//			
//			for(int i=0;i<5;i++)
//			{
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					
//					e.printStackTrace();
//				}
//				System.out.println("Hi");
//			}
//				
//		});  
//		Thread t2=new Thread(() -> {
//			
//			for(int i=0;i<5;i++)
//			{
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//				
//					e.printStackTrace();
//				}
//				System.out.println("Hello");
//			}
//		});
//		
//		t1.start();                
//			
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		
//		t2.start();
//	}
//
//}