package com.wzd.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : UDPChat
 * @description：UDP聊天线程
 * @modified By：
 * @date ：Created in 2019/02/01/0001 7:31
 */
public class UDPChat implements Runnable{
    @Override
    public void run() {
        DatagramSocket sendSocket = null;
        DatagramSocket receiveSocket = null;
        System.out.println("客户端启动。。。。");
        try {
            //开启UDP发送服务
            sendSocket = new DatagramSocket();
            //开启UDP接收服务
            receiveSocket = new DatagramSocket(12002,InetAddress.getLocalHost());
            //接受用户输入的数据，将数据封装到数据包中
            Scanner scanner = new Scanner(System.in);
            String line = "";
            DatagramPacket datagramPacket1 = null;
            DatagramPacket datagramPacket2 = null;
            byte[] bytes = new byte[1024 * 8];
            while (true){
                line = scanner.nextLine();
                datagramPacket1 = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getLocalHost(), 12001);
                sendSocket.send(datagramPacket1);
                datagramPacket2 = new DatagramPacket(bytes, bytes.length);
                receiveSocket.receive(datagramPacket2);
                System.out.println("接收端发送消息为： " + new String(bytes,0,datagramPacket2.getLength(),"Utf-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (receiveSocket != null){
                receiveSocket.close();
            }
            if (sendSocket != null){
                sendSocket.close();
            }
        }
    }
}
