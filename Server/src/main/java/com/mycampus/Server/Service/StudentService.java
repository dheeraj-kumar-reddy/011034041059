package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.OnJoiningResponse;
import com.mycampus.Server.Entity.StudentRegistration;
import com.mycampus.Server.Entity.User;
import com.mycampus.Server.Repository.Student;
import com.mycampus.Server.Repository.UserRepo;
import com.mycampus.Server.Util.MyCampusUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StudentService {

    private static Logger MCLogger = LogManager.getLogger(StudentService.class);

    @Autowired
    private Student studentRepo;

    @Autowired
    private UserRepo userRepo;

    public OnJoiningResponse onStudentJoining(StudentRegistration student){
        String methodName = "onStudentJoining";
        OnJoiningResponse response = new OnJoiningResponse();
        long username = student.getUsername();
        try {
            User user = userRepo.findById(username).get();
            if (userRepo.existsByUsernameAndAdmissionStatus(username, MyCampusConst.ADMISSION_CONFIRMED)){
                MCLogger.error(methodName+" User already admitted");
                MyCampusUtil.studentJoinFailed(response,MyCampusConst.EXISTING_ENTRY);
            }
            else{

            }
        }
        catch (NoSuchElementException e){
            MCLogger.error(methodName+" User not found with username: "+username,e);
            MyCampusUtil.studentJoinFailed(response, MyCampusConst.INVALID_ENTRY);
        }
        catch (Exception e){
            MCLogger.error(methodName+" Error occurred while admitting student",e);
            MyCampusUtil.studentJoinFailed(response,MyCampusConst.UNKNOWN_ERROR);
        }
        MCLogger.info(methodName+" Student Admission Response from Server: "+response);
        return response;
    }
}
