package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.LoginForm;
import com.mycampus.Server.Entity.LoginResponse;
import com.mycampus.Server.Entity.User;
import com.mycampus.Server.Repository.UserRepo;
import com.mycampus.Server.Util.MyCampusUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static Logger MCLogger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;
    public LoginResponse userLogin(LoginForm loginForm){
        String methodName = "userLogin";
        LoginResponse loginResponse = null;
        try{
            long username = loginForm.getUsername();
            String password = loginForm.getPassword();
            if(userRepo.existsById(username)){
                MyCampusUtil.failedLogin(loginResponse, MyCampusConst.EXISTING_ENTRY);
                return loginResponse;
            }
            else{
                User user = userRepo.fin
            }

        }
        catch (Exception e){
            MyCampusUtil.failedLogin(loginResponse, MyCampusConst.UNKNOWN_ERROR);
            MCLogger.error(methodName+" failed to login",e);
        }
        return loginResponse;
    }
}
