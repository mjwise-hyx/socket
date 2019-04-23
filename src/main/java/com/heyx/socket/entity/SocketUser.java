package com.heyx.socket.entity;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-22 14:22
 * @email; 1064042411@qq.com
 */
public class SocketUser {
    private String name;
    private String account;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public SocketUser(String name,final Socket socket ) throws IOException {
        this.name = name;
        this.socket = socket;
        //读取客户端传输的 输入流
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        //转发给客户端的 输出流
        this.pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
    }

    @Override
    public String toString() {
        return "SocketUser{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", socket=" + socket +
                ", br=" + br +
                ", pw=" + pw +
                '}';
    }
}
