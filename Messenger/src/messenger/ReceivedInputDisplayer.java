package messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceivedInputDisplayer implements Runnable {

	Socket socket;

	public ReceivedInputDisplayer(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			String receivedData;
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while ((receivedData = reader.readLine())!=null) {
				System.out.println("Received " + receivedData);
			}
			System.out.println("stopped receiving input");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
