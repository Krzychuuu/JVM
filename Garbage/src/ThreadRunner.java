
public class ThreadRunner implements Runnable {
		 
	    private int id;
	    
	    public static int threadNumber = 100;
	    
	    public ThreadRunner(int id) {
	        this.id = id;
	    }
	    public void run() {
				System.out.println("Watek "+id);

	        	for(int i = threadNumber; i >= 0; i--) {
	        		MemoryEater.alloc(2);
	        		MemoryEater.alloc(4);
	        		MemoryEater.alloc(6);
	        		threadNumber--;
	        	}
	           
	    }

	    
}
