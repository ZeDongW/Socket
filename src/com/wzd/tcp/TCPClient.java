package com.wzd.tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : TCPClient
 * @description：TCP聊天客户端
 * @modified By：
 * @date ：Created in 2019/02/01/0001 7:01
 */
public class TCPClient {
    public static void main(String[] args) {

        //开启TCP服务
        Socket socket = null;
        //
        try {
            socket = new Socket(InetAddress.getLocalHost(),12001);
            //获取流对象
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("新年快乐！！！");
            bufferedWriter.flush();
            System.out.println("发送成功！！！");
        } catch (IOException e) {
            throw  new RuntimeException(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw  new RuntimeException(e);
                }
            }
        }


    }
}
