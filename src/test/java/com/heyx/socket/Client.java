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

    public static final String NGROK = "ngrok.uv2z.cn";
    public static final String VULTR = "149.28.156.230";

    public static void main(String[] args) {
        try {

            Socket socket = new Socket( VULTR, 18888);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            InputStream isr =  System.in;
//            while (!"bye".equals(isr.toString())){
//                pw.write(isr.toString());
//                pw.flush();
//            }

            pw.write("123");
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
