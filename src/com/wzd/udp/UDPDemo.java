package com.wzd.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : UDPDemo
 * @description：UDP通信演示类
 * @modified By：
 * @date ：Created in 2019/01/31/0031 7:44
 */
public class UDPDemo {
    public static void main(String[] args) throws IOException {
        //建立UDP服务
        DatagramSocket datagramSocket = new DatagramSocket();
        //准备数据
        String data = "大家早上好！！！";
        //将数据封装到数据包中
        DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, InetAddress.getLocalHost(), 12001);
        //调用UDP服务发送数据包
        datagramSocket.send(datagramPacket);
        //关闭连接
        datagramSocket.close();
    }
}
