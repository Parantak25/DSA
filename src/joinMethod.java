
class MyThread extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("CHILD THREAD");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



public class joinMethod {

	public static void main(String[] args) throws InterruptedException {
		MyThread t=new MyThread();


		t.start();
		
		t.join();  //executed my main thread, i.e the main thread will go into waiting state until child threads completes.
		
		for(int i=0;i<5;i++)
			System.out.println("MAIN THREAD");

	}

}
