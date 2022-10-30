package com.mycampus.Server.Util;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.*;
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
        user.setAdmissionStatus(getUserAdmissionStatus(user.getRole()));
        user.setUsername(System.currentTimeMillis());
        return user;
    }

    public static int getUserAdmissionStatus(int role){
        int admissionStatus = MyCampusConst.ADMISSION_NOT_YET_CONFIRMED;
        if(role != MyCampusConst.STUDENT_USER){
            admissionStatus = MyCampusConst.FACULTY_ADMISSION;
        }
        return admissionStatus;
    }

    public static User updateUserDetails(User user, UpdateUser updateUser){
        if (updateUser.getNewPassword() != null) {
            user.setPassword(updateUser.getNewPassword());
        }
        if (updateUser.mailId != null){
            user.setEmailId(updateUser.getMailId());
        }
        if(updateUser.getMobileNo() != 0){
            user.setMobileNo(updateUser.getMobileNo());
        }
        if(updateUser.getName() != null){
            user.setName(updateUser.getName());
        }
        if(updateUser.getRole() != 0) {
            user.setRole(updateUser.getRole());
            int admissionStatus = MyCampusUtil.getUserAdmissionStatus(updateUser.getRole());
            if(user.getAdmissionStatus() == MyCampusConst.ADMISSION_CONFIRMED){
                admissionStatus = MyCampusConst.ADMISSION_CONFIRMED;
            }
            user.setAdmissionStatus(admissionStatus);
        }
        if(updateUser.getDateOfBirth() != null) {
            user.setDateOfBirth(updateUser.getDateOfBirth());
        }
        if(updateUser.getGender() != 0) {
            user.setGender(updateUser.getGender());
        }
        return user;
    }
}
