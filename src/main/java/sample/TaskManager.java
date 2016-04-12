package sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager {
	
	static private TaskManager instace = null;
	private ExecutorService executor = null;
	
	private TaskManager() {

		executor =  Executors.newSingleThreadExecutor();
	}
	
	synchronized static public TaskManager getInstance() {
		if (instace == null) {
			instace = new TaskManager();
		}
		return instace;
		
	}
	
	public void exec(int requestId) {
		Runnable runnable = new Runnable() {

			public void run() {
				System.out.println("RequestId " + requestId + ":ThreadId " + Thread.currentThread().getId() + " is running.");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
				System.out.println("RequestId " + requestId + ":ThreadId " + Thread.currentThread().getId() + " is finished.");
			}
			
		};
		executor.execute(runnable);
	}
}
