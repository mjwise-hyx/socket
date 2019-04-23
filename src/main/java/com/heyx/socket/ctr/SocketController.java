package com.heyx.socket.ctr;

import com.heyx.socket.service.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-22 14:11
 * @email; 1064042411@qq.com
 */
@RestController
@RequestMapping("/")
public class SocketController {

    @Autowired
    SocketService socketService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/start")
    public void startServer(){
        socketService.StartServerSocketDemo();
    }

    @RequestMapping("/stop")
    public void stopServer(){
        socketService.StopServerSocketDemo();
    }
}
