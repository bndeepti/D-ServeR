package com.dserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   public static void main(String... args) {
       System.out.println("Server is starting..");
       try {
           ServerSocket serverSocket = new ServerSocket(8090);
           while (true) {
               Socket clientSocket = serverSocket.accept();
               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
               bufferedReader.lines().forEach(line -> System.out.println(line));
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
