package com.mycampus.Server.Controller;

import com.mycampus.Server.Entity.*;
import com.mycampus.Server.Service.BranchService;
import com.mycampus.Server.Service.DepartmentService;
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
    private static Logger MCLogger = LogManager.getLogger(ServerController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private BranchService branchService;

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
    public OnJoiningResponse onStudentJoining(@RequestBody StudentRegistration student){
        String methodName = "onStudentJoining";
        MCLogger.info(methodName+" Student details from client: "+ student);
        return studentService.onStudentJoining(student);
    }

    @PostMapping("/adddepartment")
    public Response addDepartment(@RequestBody Department department){
        String methodName = "addDepartment";
        MCLogger.info(methodName+" Department details from client: "+department);
        return departmentService.addDepartment(department);
    }

    @GetMapping("/getalldepartments")
    public List<DepartmentListToUI> getAllDepartments(){
        String methodName = "getAllDepartments";
        MCLogger.info(methodName+" Get all departments request from client");
        return departmentService.getAllDepartments();
    }

    @PostMapping("/addbranch")
    public Response addBranch(@RequestBody BranchRegistration branchRegistration){
        String methodName = "addBranch";
        MCLogger.info(methodName+" Branch details from client: "+branchRegistration);
        return branchService.addBranch(branchRegistration);
    }

    @GetMapping("/getallbranches")
    public List<BranchToUI> getAllBranches(){
        String methodName = "getAllBranches";
        MCLogger.info(methodName+" Get all branches request from client");
        return branchService.getAllBranches();
    }
}
