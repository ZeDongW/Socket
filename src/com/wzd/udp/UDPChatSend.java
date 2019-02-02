package com.wzd.udp;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : UDPChatSend
 * @description：UDP实时聊天工具
 * @modified By：
 * @date ：Created in 2019/02/01/0001 7:30
 */
public class UDPChatSend {
    public static void main(String[] args) {
        Thread thread = new Thread(new UDPChat());
        thread.start();
    }
}
