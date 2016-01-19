package com.dserver.handler;

import com.dserver.model.StartLines.RequestLine;

import java.io.*;
import java.net.Socket;

public class RequestHandler {
    public void processGetRequest(RequestLine requestLine, Socket client) throws IOException {
        String currentLine;
        if(requestLine.getRequestUrl().contains("file")) {
            String filePath = new File("").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(filePath + "/src/main/resources/file.txt"));
            while ((currentLine = br.readLine()) != null) {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                writer.write(currentLine);
                writer.flush();
                writer.close();
            }
        }
    }
}
