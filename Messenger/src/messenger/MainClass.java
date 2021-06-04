package messenger;

public class MainClass {

	public static void main(String[] args) {

		ControlVariables controlVariables = new ControlVariables();
		Thread userRequestWaiter = new Thread(new UserRequestWaiter(controlVariables));
		Thread otherConnWaiter = new Thread(
				new OtherConnWaiter(Integer.valueOf(args[0]), controlVariables));
		otherConnWaiter.start();
		userRequestWaiter.start();
		
	}

}
