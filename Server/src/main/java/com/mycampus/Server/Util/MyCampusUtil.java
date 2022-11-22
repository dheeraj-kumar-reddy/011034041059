package com.mycampus.Server.Util;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.*;
import com.mycampus.Server.MyCampusConfigProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.mycampus.Server.MyCampusConfigProperties.getPucMarksSheetDirectory;

public class MyCampusUtil {
    private static Logger MCLogger = LogManager.getLogger(MyCampusUtil.class);

    public static LoginResponse failedLogin(LoginResponse loginResponse, int errorCode){
        loginResponse.setRole(MyCampusConst.INVALID_ROLE);
        loginResponse.setStatus(MyCampusConst.FAILURE);
        loginResponse.setErrorCode(errorCode);
        loginResponse.setLastLoginTime(MyCampusConst.INVALID_LAST_LOGIN_TIME);
        return loginResponse;
    }

    public static LoginResponse successLogin(LoginResponse loginResponse, int role, long lastLoginTime){
        loginResponse.setErrorCode(MyCampusConst.NO_ERROR);
        loginResponse.setStatus(MyCampusConst.SUCCESS);
        loginResponse.setRole(role);
        loginResponse.setLastLoginTime(lastLoginTime);
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

    public static OnJoiningResponse studentJoinFailed(OnJoiningResponse response, int errorCode){
        response.setErrorCode(errorCode);
        response.setStatus(MyCampusConst.FAILURE);
        response.setId(MyCampusConst.INVALID_ID);
        return response;
    }

    public static OnJoiningResponse studentJoinSuccess(OnJoiningResponse response, String id){
        response.setId(id);
        response.setStatus(MyCampusConst.SUCCESS);
        response.setErrorCode(MyCampusConst.NO_ERROR);
        return response;
    }

    public static User setUserVerificationStatus(User user){
        if ((user.getRole() == MyCampusConst.STUDENT_USER)) {
            user.setVerificationStatus(MyCampusConst.USER_VERIFICATION_SUCCESS);
        }
        else {
            user.setVerificationStatus(MyCampusConst.USER_VERIFICATION_FAILURE);
        }
        return user;
    }

    public static String get10thClassMarksSheetName(long username){
        return MyCampusConst.X_MARKS_SHEET_FORMAT.replaceAll(MyCampusConst.REPLACE_USERNAME,Long.toString(username));
    }

    public static String getTcName(long username){
        return MyCampusConst.TC_FORMAT.replaceAll(MyCampusConst.REPLACE_USERNAME,Long.toString(username));
    }

    public static String getPucMarksSheetName(long username){
        return MyCampusConst.PUC_MARKS_SHEET_FORMAT.replaceAll(MyCampusConst.REPLACE_USERNAME,Long.toString(username));
    }

    public static String getUgMarksSheetName(long username){
        return MyCampusConst.UG_MARKS_SHEET_FORMAT.replaceAll(MyCampusConst.REPLACE_USERNAME,Long.toString(username));
    }

    public static String getOtherDocName(long username){
        return MyCampusConst.OTHER_DOC_FORMAT.replaceAll(MyCampusConst.REPLACE_USERNAME,Long.toString(username));
    }

    public static String getFilePath(String typeOfDocument, String filename){
        String filePath = null;
        if(typeOfDocument.equals(MyCampusConst.TENTH)) {
            filePath = MyCampusConfigProperties.getTenthMarksSheetDirectory() + filename;
        } else if (typeOfDocument.equals(MyCampusConst.PUC)) {
            filePath = getPucMarksSheetDirectory() + filename;
        } else if (typeOfDocument.equals(MyCampusConst.UG)) {
            filePath = MyCampusConfigProperties.getUgMarksSheetDirectory() + filename;
        } else if (typeOfDocument.equals(MyCampusConst.TC)){
            filePath = MyCampusConfigProperties.getTcDirectory() + filename;
        } else {
            filePath = MyCampusConfigProperties.getOtherDocumentsDirectory() + filename;
        }
        return filePath;
    }

    public static Path getFileStorageLocation(String typeOfDocument){
        Path fileStorageLocation = null;
        if (typeOfDocument.equals(MyCampusConst.TENTH)){
            fileStorageLocation = Paths.get(MyCampusConfigProperties.getTenthMarksSheetDirectory()).toAbsolutePath().normalize();
        } else if (typeOfDocument.equals(MyCampusConst.PUC)) {
            fileStorageLocation = Paths.get(MyCampusConfigProperties.getPucMarksSheetDirectory()).toAbsolutePath().normalize();
        } else if (typeOfDocument.equals(MyCampusConst.UG)) {
            fileStorageLocation = Paths.get(MyCampusConfigProperties.getUgMarksSheetDirectory()).toAbsolutePath().normalize();
        } else if (typeOfDocument.equals(MyCampusConst.TC)) {
            fileStorageLocation = Paths.get(MyCampusConfigProperties.getTcDirectory()).toAbsolutePath().normalize();
        } else {
            fileStorageLocation = Paths.get(MyCampusConfigProperties.getOtherDocumentsDirectory()).toAbsolutePath().normalize();
        }
        return fileStorageLocation;
    }
}
