package com.mycampus.Server.Controller;

import com.mycampus.Server.Entity.*;
import com.mycampus.Server.Service.StudentService;
import com.mycampus.Server.Service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4400")
@RestController
@RequestMapping("/mycampus")
public class ServerController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

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

    @GetMapping("/getallusers")
    public List<User> getAllUsers(){
        String methodName = "getAllUsers";
        MCLogger.info(methodName+" Getting all users data from server");
        return userService.getAllUsers();
    }

    @GetMapping("/getuserdetails/{username}")
    public User getUserDetails(@PathVariable(value = "username") long username){
        String methodName = "getUserDetails";
        MCLogger.info(methodName+" Getting user details from server, username "+username);
        return userService.getUserDetails(username);
    }

    @PostMapping("/updateuserdetails")
    public Response updateUserDetails(@RequestBody UpdateUser updateUser){
        String methodName = "updateUserDetails";
        MCLogger.info(methodName+" Update user details from client "+updateUser);
        return userService.updateUserDetails(updateUser);
    }

    @PostMapping("/onstudentjoin")
    public OnJoiningResponse onStudentJoining(StudentRegistration student){
        String methodName = "onStudentJoining";
        MCLogger.info(methodName+" Student details from client: "+ student);
        return studentService.onStudentJoining(student);
    }
}
