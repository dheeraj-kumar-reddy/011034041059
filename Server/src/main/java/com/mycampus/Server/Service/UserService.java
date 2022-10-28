package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.*;
import com.mycampus.Server.Repository.UserRepo;
import com.mycampus.Server.Util.MyCampusUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private static Logger MCLogger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    //User Creation
    public UserCreationResponse createUser(User user){
        String methodName = "createUser";
        UserCreationResponse response = new UserCreationResponse();
        try{
            if((userRepo.findByMobileNo(user.getMobileNo())!=null) || (userRepo.findByEmailId(user.getEmailId())!=null)){
                MCLogger.error(methodName+" User Already Registered");
                MyCampusUtil.userCreationFailed(response,MyCampusConst.EXISTING_ENTRY);
            }
            else{
                MyCampusUtil.updateStatusAndUserName(user);
                userRepo.save(user);
                long username = user.getUsername();
                MyCampusUtil.userCreationSuccess(response,user.getUsername());
                MCLogger.info(methodName+" Creation of user successful with username: "+user.getUsername());
            }
        }
        catch (Exception e){
            MCLogger.error(methodName+" Failed to create a new user",e);
            MyCampusUtil.userCreationFailed(response,MyCampusConst.UNKNOWN_ERROR);
        }
        MCLogger.info(methodName+" User Creation Response from Server "+response);
        return response;
    }

    //User Login
    public LoginResponse userLogin(LoginForm loginForm){
        String methodName = "userLogin";
        LoginResponse loginResponse = new LoginResponse();
        long username = loginForm.getUsername();
        String password = loginForm.getPassword();
        try {
            User user = userRepo.findById(username).get();
            if(!user.getPassword().equals(password)){
                MCLogger.error(methodName+MyCampusConst.SPACE+"Invalid password for username "+username);
                MyCampusUtil.failedLogin(loginResponse,MyCampusConst.INVALID_CREDENTIALS);
            }
            else{
                user.setLastLoginTime(System.currentTimeMillis());
                user.setAccountStatus(MyCampusConst.ACCOUNT_LOGGED_IN);
                userRepo.save(user);
                MyCampusUtil.successLogin(loginResponse, user.getRole());
            }
        }
        catch (NoSuchElementException e){
            MyCampusUtil.failedLogin(loginResponse,MyCampusConst.INVALID_ENTRY);
            MCLogger.error(methodName+MyCampusConst.SPACE+username+" not found");
        }
        catch (Exception e){
            MyCampusUtil.failedLogin(loginResponse, MyCampusConst.UNKNOWN_ERROR);
            MCLogger.error(methodName+" failed to login",e);
        }
        MCLogger.info(methodName+" Login response from server "+loginResponse);
        return loginResponse;
    }

    //User Logout
    public Response userLogout(LogoutForm logoutForm){
        String methodName = "userLogout";
        long username = logoutForm.getUsername();
        Response response = new Response();
        try{
            User user = userRepo.findById(username).get();
            user.setAccountStatus(MyCampusConst.ACCOUNT_ACTIVE);
            userRepo.save(user);
            MCLogger.info(methodName+MyCampusConst.SPACE+username+" Logged out successfully");
            MyCampusUtil.successResponse(response);
        }
        catch (NoSuchElementException e){
            MCLogger.error(methodName+MyCampusConst.SPACE+username+" not found, failed to login");
            MyCampusUtil.failureResponse(response,MyCampusConst.INVALID_ENTRY);
        }
        catch (Exception e){
            MCLogger.error(methodName+MyCampusConst.SPACE+"Exception occurred during logout",e);
            MyCampusUtil.failureResponse(response,MyCampusConst.UNKNOWN_ERROR);
        }
        MCLogger.info(methodName+" LogOut response from server "+response);
        return response;
    }
}
