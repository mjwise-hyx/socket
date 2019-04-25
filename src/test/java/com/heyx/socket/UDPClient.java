package com.heyx.socket;

import java.io.IOException;
import java.net.*;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-24 14:26
 * @email; 1064042411@qq.com
 */
public class UDPClient {
    public static void main(String[] args)throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data = "用户名：admin 密码： 123".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        byte[] data2 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data2, data2.length, address, port);
        socket.receive(packet1);
        String replay = new String(data2, 0, packet1.getLength());
        System.out.println("我是客户端，服务器说："+replay);
        socket.close();
    }
}
