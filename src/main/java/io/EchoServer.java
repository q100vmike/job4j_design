package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        StringBuilder message = new StringBuilder();
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String string = input.readLine(); string != null && !string.isEmpty(); string = input.readLine()) {
                        System.out.println(string);
                        message.append(string);
                    }
                    if (message.indexOf("msg=Exit") > 0) {
                        server.close();
                    } else if (message.indexOf("msg=Hello") > 0) {
                        output.write("Hello".getBytes());
                    } else {
                        output.write("What".getBytes());
                    }
                    output.flush();
                }
            }
        }
    }
}