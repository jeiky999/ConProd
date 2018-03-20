import java.util.LinkedList;

public class ConProd
    {
        LinkedList<Integer> list = new LinkedList<>();
        
        int value = 0;
        
        public void produce() throws InterruptedException
        { 
            while (true)
            {
                synchronized (this)
                {
                    while (list.size()==2)
                        wait();
                    
                    System.out.println("Producer produced-" + value);
 
                    list.add(value++);
 
                    notify();
 
                    Thread.sleep(1000);
                }
            }
        }
 
        public void consume() throws InterruptedException
        {
            while (true)
            {
                synchronized (this)
                {
                    while (list.size()==0)
                        wait();
                    
                    int val = list.removeFirst();
                    
                     System.out.println("Consumer consumed-" + val);
                     
                    value--;
                    
                    notify();
                    
                    Thread.sleep(1000);
                }
            }
        }
}
