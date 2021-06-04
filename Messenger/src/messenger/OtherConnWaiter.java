package messenger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OtherConnWaiter implements Runnable {

	int listenerPort;
	ControlVariables control;
	Thread waiter;

	public OtherConnWaiter(int listenerPort, ControlVariables control) {
		super();
		this.listenerPort = listenerPort;
		this.control = control;
	}

	@Override
	public void run() {
		try {
			ServerSocket serverSocket;
			serverSocket = new ServerSocket(listenerPort);
			System.out.println("listening at " + serverSocket.getLocalPort());
			Socket socket = serverSocket.accept();
			control.setToStopUserRequestWaiter(true);
			System.out.println("accepted connection from " + socket.getPort());
			Thread userMessageDisplayer = new Thread(new UserMessageDisplayer(socket));
			userMessageDisplayer.start();
			Thread receivedInputDisplayer = new Thread(new ReceivedInputDisplayer(socket));
			receivedInputDisplayer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
