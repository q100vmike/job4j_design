package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String string = input.readLine();
                    if (string != null && !string.isEmpty()) {
                        if (string.indexOf("msg=Exit") > 0) {
                            server.close();
                        } else if (string.indexOf("msg=Hello") > 0) {
                            output.write("Hello".getBytes());
                        } else {
                            output.write("What".getBytes());
                        }
                    }
                    output.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in ServerSocket", e);
        }
    }
}