package com.wzd.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : SocketDemo
 * @description：Socket演示
 * @modified By：
 * @date ：Created in 2019/01/31/0031 6:44
 */
public class SocketDemo {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress());
            System.out.println(localHost.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
