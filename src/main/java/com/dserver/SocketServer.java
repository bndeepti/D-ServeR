package com.dserver;

import com.dserver.handler.RequestHandler;
import com.dserver.model.StartLines.HttpMethod;
import com.dserver.model.StartLines.RequestLine;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private ServerSocket serverSocket;
    private int port;

    public SocketServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        System.out.println("Starting the socket server at port:" + port);
        serverSocket = new ServerSocket(port);
        System.out.println("Waiting for clients...");
        Socket client = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String[] requestLineParameters = bufferedReader.readLine().split(" ");
        RequestLine requestLine = new RequestLine(requestLineParameters);
        processRequest(requestLine, client);
    }

    private void processRequest(RequestLine requestLine, Socket client) {
        if(requestLine.getMethod() == HttpMethod.GET) {
            try {
                new RequestHandler().processGetRequest(requestLine, client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int portNumber = 9990;
        try {
            SocketServer socketServer = new SocketServer(portNumber);
            socketServer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}