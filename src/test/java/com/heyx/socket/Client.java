package com.heyx.socket;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-23 17:58
 * @email; 1064042411@qq.com
 */
public class Client {
    public static void main(String[] args) {
        try {

            Socket socket = new Socket( "127.0.0.1", 18888);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admin ;密码：123");
            pw.flush();
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务器说： " + info);
            }

            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
