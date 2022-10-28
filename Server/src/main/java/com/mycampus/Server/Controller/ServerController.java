package com.mycampus.Server.Controller;

import com.mycampus.Server.Entity.*;
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

    @PostMapping("/adduser")
    public UserCreationResponse createUser(@RequestBody User user){
        String methodName = "createUser";
        MCLogger.info(methodName+" Details from client: "+user);
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public LoginResponse userLogin(@RequestBody LoginForm loginForm){
        String methodName = "userLogin";
        MCLogger.info(methodName+" Credentials received from client: "+loginForm);
        return userService.userLogin(loginForm);
    }

    @PostMapping("/logout")
    public Response userLogout(@RequestBody LogoutForm logoutForm){
        String methodName = "userLogout";
        MCLogger.info(methodName+" Credentials received from client: "+logoutForm);
        return userService.userLogout(logoutForm);
    }
}
