package com.heyx.socket.service;

import com.heyx.socket.entity.SocketUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-22 14:13
 * @email; 1064042411@qq.com
 */
@Service
public class SocketService {

    private ServerSocket serverSocket;

    public void StartServerSocketDemo(){
        int count = 0;
        try{
            List<SocketUser> list = new ArrayList<>();
            serverSocket = new ServerSocket(8080);
            System.out.println("服务端已启动");
            while (true){
                Socket socket=serverSocket.accept();
                count++;
                SocketUser user = new SocketUser("user" + count,socket);
                System.out.println(user.getName() + "正在登录。。。");
                list.add(user);//把新增的用户添加到list里面
                System.out.println(list);
                System.out.println("客户端的IP："+socket.getInetAddress().getHostAddress());
                new ServerThread(user,list).run();//开启输入和输出的多线程
            }

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void StopServerSocketDemo(){
        if (serverSocket != null){
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
