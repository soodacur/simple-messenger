package messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserMessageDisplayer implements Runnable {

	Socket socket;

	public UserMessageDisplayer(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input;
			while ((input = reader.readLine()) != null) {
				out.println(input);
				System.out.println("Sent " + input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
