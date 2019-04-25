package com.heyx.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-24 13:29
 * @email; 1064042411@qq.com
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8800);
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        socket.receive(packet);
        String info = new String(data, 0, packet.getLength());
        System.out.println("我是服务器，客户端说："+ info);

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2="欢迎您!".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data2,data2.length,address,port);
        socket.send(packet1);
        socket.close();
    }
}
