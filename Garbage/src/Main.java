import java.util.Timer;
import java.util.TimerTask;


public class Main {
	public static void main(String[] args){

		
		final Runnable[] runners = new Runnable[4];
        final Thread[] threads = new Thread[4];
		long startTime = System.nanoTime();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			  public void run() {
			        for(int i=0; i<4; i++) {
			            runners[i] = new ThreadRunner(i);
			            threads[i] = new Thread(runners[i]);
			            threads[i].start();
			        }
			  }
		}, 5*1000);
		int watkow = ThreadRunner.threadNumber;
//        while(ThreadRunner.threadNumber >= 0){
//        	
//        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Alokacji: "+watkow+"\n");
        System.out.println("4 W¹tki o sta³ym rozmiarze: "+ estimatedTime + "ns\n");
        System.out.println("Srednio: "+estimatedTime/watkow+"ns");
	}

}
