package sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/task")
public class TaskService {

	static int index = 0;
	
	@GET
	@Path("/")
	public void start() {
		
		System.out.println("TaskService.start is called. RequestId is " + index);
		
		TaskManager timer = TaskManager.getInstance();
		timer.exec(index++);
		
	}
}
