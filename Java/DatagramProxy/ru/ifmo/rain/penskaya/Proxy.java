package ru.ifmo.rain.penskaya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Proxy {
    int[] localPort;
    InetAddress[] remoteHost;
    int[] remotePort;

    public String fileToString(String path) throws IOException {
        InputStream inFile = this.getClass().getResourceAsStream(path);
        BufferedReader buf = new BufferedReader(new InputStreamReader(inFile));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line).append(" ");
            line = buf.readLine();
        }
        String fileAsString = sb.toString();
        return fileAsString;
    }

    public Proxy(String filePath) throws IOException {
        String str = fileToString(filePath);
        String[] words = str.split(" ");
        int size = words.length / 3;
        this.localPort = new int[size];
        this.remoteHost = new InetAddress[size];
        this.remotePort = new int[size];
        int j = 0;
        for (int i = 2; i < words.length; i += 3){
            localPort[j] = Integer.parseInt(words[i-2]);
            remoteHost[j] = InetAddress.getByName(words[i-1]);
            remotePort[j] = Integer.parseInt(words[i]);
            ++j;
        }

    }

    public void redirectOneDatagram(int localP, InetAddress remoteH, int remoteP) throws IOException {
        DatagramSocket localSocket = new DatagramSocket(localP);
        localSocket.connect(remoteH, remoteP);
    }

    public void printData(){
        for(int i = 0; i < localPort.length; ++i){
            System.out.println(localPort[i] + " " + remoteHost[i] + " " + remotePort[i]);
        }
    }



}
