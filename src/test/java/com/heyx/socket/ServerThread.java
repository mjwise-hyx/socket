package com.heyx.socket;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-24 10:01
 * @email; 1064042411@qq.com
 */
public class ServerThread extends Thread {

    Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        InputStream is = null;
        PrintWriter pw = null;
        InputStreamReader isr = null;
        OutputStream os = null;
        BufferedReader br = null;
        Writer out = null;
        String fileName = this.getName();
        File file = new File("E:/" + fileName + "-扬尘噪声.txt");
        try {
            file.createNewFile();
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            out = new FileWriter(file);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("客户端： " + info);
                out.write(info);

            }
            socket.shutdownInput();

            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您!");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (null != pw){
                    pw.close();
                }
                if (null != os){
                    os.close();
                }
                if (null != br){
                    br.close();
                }
                if (null != is){
                    is.close();
                }
                if (null != out){
                    out.close();
                }
                if (null != socket){
                    socket.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }



    }
}
