package com.dserver;

import java.io.*;
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
//               bufferedReader.lines().forEach(line -> System.out.println(line));
               BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
               bufferedWriter.write("HTTP/1.1 200 OK \r\n");
               bufferedWriter.flush();
               bufferedWriter.close();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
