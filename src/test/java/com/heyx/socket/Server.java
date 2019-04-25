package com.heyx.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-23 17:58
 * @email; 1064042411@qq.com
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(18888);
            Socket socket = null;
            System.out.println("***服务器启动");
            int count = 0;
            while (true) {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count ++;
                System.out.println("客户端数量：" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP:" + address.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
