package com.mycampus.Server.Util;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.LoginResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyCampusUtil {
    private static Logger MCLogger = LogManager.getLogger(MyCampusUtil.class);

    public static LoginResponse failedLogin(LoginResponse loginResponse, int errorCode){
        loginResponse.setRole(MyCampusConst.INVALID_ROLE);
        loginResponse.setStatus(MyCampusConst.SUCCESS);
        loginResponse.setErrorCode(errorCode);
        return loginResponse;
    }
}
