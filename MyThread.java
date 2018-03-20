
public class MyThread {
	 public static void main(String[] args) throws InterruptedException
	 {
		 final ConProd conprod = new ConProd();

		 Thread producer = new Thread(new Runnable()
		 {
			 @Override
			 public void run()
			 {
				 try
				 {
					 conprod.produce();
				 }
				 catch(InterruptedException e)
				 {
					 e.printStackTrace();
				 }
			 }
		 });

		 Thread consumer = new Thread(new Runnable()
		 {
			 @Override
			 public void run()
			 {
				 try
				 {
					 conprod.consume();
				 }
				 catch(InterruptedException e)
				 {
					 e.printStackTrace();
				 }
			 }
		 });

		 producer.start();
		 consumer.start();

		 producer.join();
		 consumer.join();
	}
}
