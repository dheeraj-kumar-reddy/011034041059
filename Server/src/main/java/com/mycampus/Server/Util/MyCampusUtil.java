package com.mycampus.Server.Util;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.LoginResponse;
import com.mycampus.Server.Entity.Response;
import com.mycampus.Server.Entity.User;
import com.mycampus.Server.Entity.UserCreationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyCampusUtil {
    private static Logger MCLogger = LogManager.getLogger(MyCampusUtil.class);

    public static LoginResponse failedLogin(LoginResponse loginResponse, int errorCode){
        loginResponse.setRole(MyCampusConst.INVALID_ROLE);
        loginResponse.setStatus(MyCampusConst.FAILURE);
        loginResponse.setErrorCode(errorCode);
        return loginResponse;
    }

    public static LoginResponse successLogin(LoginResponse loginResponse, int role){
        loginResponse.setErrorCode(MyCampusConst.NO_ERROR);
        loginResponse.setStatus(MyCampusConst.SUCCESS);
        loginResponse.setRole(role);
        return loginResponse;
    }

    public static Response successResponse(Response response){
        response.setErrorCode(MyCampusConst.NO_ERROR);
        response.setStatus(MyCampusConst.SUCCESS);
        return response;
    }

    public static Response failureResponse(Response response, int errorCode){
        response.setStatus(MyCampusConst.FAILURE);
        response.setErrorCode(errorCode);
        return response;
    }

    public static UserCreationResponse userCreationFailed(UserCreationResponse userCreationResponse, int errorCode){
        userCreationResponse.setErrorCode(errorCode);
        userCreationResponse.setStatus(MyCampusConst.FAILURE);
        userCreationResponse.setUsername(MyCampusConst.INVALID_USERNAME);
        return userCreationResponse;
    }

    public static UserCreationResponse userCreationSuccess(UserCreationResponse userCreationResponse, long username){
        userCreationResponse.setUsername(username);
        userCreationResponse.setErrorCode(MyCampusConst.NO_ERROR);
        userCreationResponse.setStatus(MyCampusConst.SUCCESS);
        return userCreationResponse;
    }

    public static User updateStatusAndUserName(User user){
        user.setAccountStatus(MyCampusConst.ACCOUNT_ACTIVE);
        int admissionStatus = MyCampusConst.ADMISSION_NOT_YET_CONFIRMED;
        if(user.getRole() != MyCampusConst.STUDENT_USER){
            admissionStatus = MyCampusConst.FACULTY_ADMISSION;
        }
        user.setAdmissionStatus(admissionStatus);
        user.setUsername(System.currentTimeMillis());
        return user;
    }
}
