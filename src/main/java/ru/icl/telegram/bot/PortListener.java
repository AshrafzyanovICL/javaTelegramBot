package ru.icl.telegram.bot;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PortListener {
	
	public void start(final int port) throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bufferedWriter.write("Hello. It is Telegram Bot");
				bufferedWriter.close();
			} catch (Exception e) {
				serverSocket.close();
				break;
			}
		}
	}

}
