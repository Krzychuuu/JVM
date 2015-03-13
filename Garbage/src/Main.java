
public class Main {
	public static void main(String[] args){

		Runnable[] runners = new Runnable[4];
        Thread[] threads = new Thread[4];
		long startTime = System.nanoTime();
        for(int i=0; i<4; i++) {
            runners[i] = new ThreadRunner(i);
            threads[i] = new Thread(runners[i]);
            threads[i].start();
        }
        while(ThreadRunner.threadNumber >= 0){
        	
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("4 W¹tki o sta³ym rozmiarze: "+ estimatedTime + "ns");
	}

}
