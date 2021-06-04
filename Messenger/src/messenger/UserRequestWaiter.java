package messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class UserRequestWaiter implements Runnable {

	private ControlVariables control;

	public UserRequestWaiter(ControlVariables control) {
		super();
		this.control = control;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		try {
			while (true) {

				if (control.isToStopUserRequestWaiter()) {
					break;
				}

				if (reader.ready()) {
					input = reader.readLine();
					String parms[] = input.split(" ");
					if (parms[0].equals("connect")) {
						Socket socket = new Socket("localhost", Integer.valueOf(parms[1]));
						System.out.println("connected to " + socket.getPort());
						control.setToStopOtherConnWaiter(true);
						Thread userMessageDisplayer = new Thread(new UserMessageDisplayer(socket));
						userMessageDisplayer.start();
						Thread receivedInputDisplayer = new Thread(new ReceivedInputDisplayer(socket));
						receivedInputDisplayer.start();
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
