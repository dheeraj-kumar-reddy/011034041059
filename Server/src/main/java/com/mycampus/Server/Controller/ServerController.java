package com.mycampus.Server.Controller;

import com.mycampus.Server.Entity.LoginForm;
import com.mycampus.Server.Entity.LoginResponse;
import com.mycampus.Server.Service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4400")
@RestController
@RequestMapping("/mycampus")
public class ServerController {

    @Autowired
    private UserService userService;

    private static Logger MCLogger = LogManager.getLogger(ServerController.class);

    @PostMapping("/login")
    public LoginResponse userLogin(@RequestBody LoginForm loginForm){
        String methodName = "userLogin";
        MCLogger.info(methodName+" Credentials received from client: "+loginForm);
        return userService.userLogin(loginForm);
    }
}
