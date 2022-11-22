package com.mycampus.Server.Controller;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.*;
import com.mycampus.Server.Service.*;
import com.mycampus.Server.Util.MyCampusUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:4400", allowedHeaders = "*")
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

    @Autowired
    private FeeService feeService;

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

    @GetMapping("/getxms/{username}")
    public ResponseEntity download10thMarksSheet(@PathVariable(value = "username")long username){
        String methodName = "download10thMarksSheet";
        String filename = MyCampusUtil.get10thClassMarksSheetName(username);
        MCLogger.info(methodName+" Download 10th Marks Sheet: "+filename);
        return studentService.downloadFile(filename, MyCampusConst.TENTH);
    }

    @GetMapping("/gettc/{username}")
    public ResponseEntity downloadTc(@PathVariable(value = "username")long username){
        String methodName = "downloadTc";
        String filename = MyCampusUtil.getTcName(username);
        MCLogger.info(methodName+" Download TC: "+filename);
        return studentService.downloadFile(filename,MyCampusConst.TC);
    }

    @GetMapping("/getpucms/{username}")
    public ResponseEntity downloadPucMarksSheet(@PathVariable(value = "username")long username){
        String methodName = "downloadPucMarksSheet";
        String filename = MyCampusUtil.getPucMarksSheetName(username);
        MCLogger.info(methodName+" Download PUC marks sheet: "+filename);
        return studentService.downloadFile(filename,MyCampusConst.PUC);
    }

    @GetMapping("/getugms/{username}")
    public ResponseEntity downloadUgMarksSheet(@PathVariable(value = "username")long username){
        String methodName = "downloadUgMarksSheet";
        String filename = MyCampusUtil.getUgMarksSheetName(username);
        MCLogger.info(methodName+" Download UG Marks Sheet: "+filename);
        return studentService.downloadFile(filename,MyCampusConst.UG);
    }

    @GetMapping("/getdoc/{username}")
    public ResponseEntity downloadOtherDoc(@PathVariable(value = "username")long username){
        String methodName = "downloadOtherDoc";
        String filename = MyCampusUtil.getOtherDocName(username);
        MCLogger.info(methodName+" Download Other Doc: "+filename);
        return studentService.downloadFile(filename,MyCampusConst.OTHER_DOCUMENT);
    }

    @PostMapping("/addxms/{username}")
    public Response upload10thMarksSheet(@RequestParam(value = "file")MultipartFile file, @PathVariable(value = "username")long username){
        String methodName = "upload10thMarksSheet";
        String filename = MyCampusUtil.get10thClassMarksSheetName(username);
        MCLogger.info(methodName+" Upload 10th Marks Sheet: "+filename);
        return studentService.uploadFile(file,filename,MyCampusConst.TENTH);
    }

    @PostMapping("/addpucms/{username}")
    public Response uploadPucMarksSheet(@RequestParam(value = "file")MultipartFile file, @PathVariable(value = "username")long username){
        String methodName = "uploadPucMarksSheet";
        String filename = MyCampusUtil.getPucMarksSheetName(username);
        MCLogger.info(methodName+" Upload PUC Marks Sheet: "+filename);
        return studentService.uploadFile(file,filename,MyCampusConst.PUC);
    }

    @PostMapping("/addugms/{username}")
    public Response uploadUgMarksSheet(@RequestParam(value = "file")MultipartFile file, @PathVariable(value = "username")long username){
        String methodName = "uploadUgMarksSheet";
        String filename = MyCampusUtil.getUgMarksSheetName(username);
        MCLogger.info(methodName+" Upload UG Marks Sheet: "+filename);
        return studentService.uploadFile(file,filename,MyCampusConst.UG);
    }

    @PostMapping("/addtc/{username}")
    public Response uploadTc(@RequestParam(value = "file")MultipartFile file, @PathVariable(value = "username")long username){
        String methodName = "uploadTc";
        String filename = MyCampusUtil.getTcName(username);
        MCLogger.info(methodName+" Upload Tc: "+filename);
        return studentService.uploadFile(file,filename,MyCampusConst.TC);
    }

    @PostMapping("/adddoc/{username}")
    public Response uploadOtherDoc(@RequestParam(value = "file")MultipartFile file, @PathVariable(value = "username")long username){
        String methodName = "uploadOtherDoc";
        String filename = MyCampusUtil.getOtherDocName(username);
        MCLogger.info(methodName+" Upload Other Doc: "+filename);
        return studentService.uploadFile(file,filename,MyCampusConst.OTHER_DOCUMENT);
    }

    @PostMapping("/generatefeereceipt")
    public FeePaymentResponse generateFeeReceipt(@RequestBody FeePayment feePayment){
        String methodName = "generateFeeReceipt";
        MCLogger.info(methodName+" Generate Fee Receipt");
        return feeService.generateFeeReceipt(feePayment);
    }
}
