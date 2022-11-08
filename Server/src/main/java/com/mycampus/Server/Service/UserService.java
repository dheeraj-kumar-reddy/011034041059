package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.*;
import com.mycampus.Server.Repository.UserRepo;
import com.mycampus.Server.Util.MyCampusUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private static Logger MCLogger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    //User Creation
    public UserCreationResponse createUser(User user){
        String methodName = "createUser";
        UserCreationResponse userCreationResponse = new UserCreationResponse();
        try{
            if((userRepo.findByMobileNo(user.getMobileNo())!=null) || (userRepo.findByEmailId(user.getEmailId())!=null)){
                MCLogger.error(methodName+" User Already Registered");
                MyCampusUtil.userCreationFailed(userCreationResponse,MyCampusConst.EXISTING_ENTRY);
            }
            else{
                MyCampusUtil.updateStatusAndUserName(user);
                MyCampusUtil.setUserVerificationStatus(user);
                userRepo.save(user);
                long username = user.getUsername();
                MyCampusUtil.userCreationSuccess(userCreationResponse,user.getUsername());
                MCLogger.info(methodName+" Creation of user successful with username: "+user.getUsername());
            }
        }
        catch (Exception e){
            MCLogger.error(methodName+" Failed to create a new user",e);
            MyCampusUtil.userCreationFailed(userCreationResponse,MyCampusConst.UNKNOWN_ERROR);
        }
        MCLogger.info(methodName+" User Creation Response from Server "+userCreationResponse);
        return userCreationResponse;
    }

    //User Login
    public LoginResponse userLogin(LoginForm loginForm){
        String methodName = "userLogin";
        LoginResponse loginResponse = new LoginResponse();
        long username = loginForm.getUsername();
        String password = loginForm.getPassword();
        try {
            User user = userRepo.findById(username).get();
            if(user.getVerificationStatus() == MyCampusConst.USER_VERIFICATION_FAILURE){
                MCLogger.error(methodName+MyCampusConst.SPACE+"User not verified, username: "+username);
                MyCampusUtil.failedLogin(loginResponse,MyCampusConst.UNVERIFIED_USER);
            }
            else if(!user.getPassword().equals(password)){
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
        Response userLogoutResponse = new Response();
        try{
            User user = userRepo.findById(username).get();
            user.setAccountStatus(MyCampusConst.ACCOUNT_ACTIVE);
            userRepo.save(user);
            MCLogger.info(methodName+MyCampusConst.SPACE+username+" Logged out successfully");
            MyCampusUtil.successResponse(userLogoutResponse);
        }
        catch (NoSuchElementException e){
            MCLogger.error(methodName+MyCampusConst.SPACE+username+" not found, failed to login");
            MyCampusUtil.failureResponse(userLogoutResponse,MyCampusConst.INVALID_ENTRY);
        }
        catch (Exception e){
            MCLogger.error(methodName+MyCampusConst.SPACE+"Exception occurred during logout",e);
            MyCampusUtil.failureResponse(userLogoutResponse,MyCampusConst.UNKNOWN_ERROR);
        }
        MCLogger.info(methodName+" LogOut response from server "+userLogoutResponse);
        return userLogoutResponse;
    }

    //Find all users
    public List<User> getAllUsers(){
        String methodName = "getAllUsers";
        List<User> userList = new ArrayList<>();
        try{
            List<User> allUserList = userRepo.findAll();
            for(User user : allUserList){
                user.setPassword(MyCampusConst.HIDDEN_PASSWORD);
                userList.add(user);
            }
            MCLogger.info(methodName+" All users data retrieved successfully from the server");
        }
        catch (Exception e){
            MCLogger.error(methodName+" Error while getting all users data",e);
        }
        return userList;
    }

    public User getUserDetails(long username){
        String methodName = "getUserDetails";
        User user = new User();
        try{
            user = userRepo.findById(username).get();
            user.setPassword(MyCampusConst.HIDDEN_PASSWORD);
            MCLogger.info(methodName+" Successfully retrieved user details with username "+username);
        }
        catch (NoSuchElementException e){
            MCLogger.error(methodName+" No user found with username "+username);
        }
        catch (Exception e){
            MCLogger.error(methodName+" Exception occurred while retrieving user details with username "+username,e);
        }
        return user;
    }

    public Response updateUserDetails(UpdateUser updateUser){
        String methodName = "updateUserDetails";
        Response updateUserResponse = new Response();
        long username = updateUser.getUsername();
        try{
            User user = userRepo.findById(username).get();
            if(!updateUser.getCurrentPassword().equals(user.getPassword())){
                MyCampusUtil.failureResponse(updateUserResponse,MyCampusConst.INVALID_CREDENTIALS);
                MCLogger.error(methodName+" Invalid user current password, username "+username);
            }
            else{
                MyCampusUtil.updateUserDetails(user, updateUser);
                userRepo.save(user);
                MyCampusUtil.successResponse(updateUserResponse);
                MCLogger.info(methodName+" User details updated successfully, username "+username);
            }
        }
        catch (NoSuchElementException e){
            MyCampusUtil.failureResponse(updateUserResponse,MyCampusConst.INVALID_ENTRY);
            MCLogger.error(methodName+" user not found, username "+username);
        }
        catch (Exception e){
            MyCampusUtil.failureResponse(updateUserResponse,MyCampusConst.INVALID_ENTRY);
            MCLogger.error(methodName+" Error while updating user details, username "+username,e);
        }
        MCLogger.info(methodName+" User update response from server "+updateUserResponse);
        return updateUserResponse;
    }
}
