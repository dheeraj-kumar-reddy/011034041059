package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.BranchRegistration;
import com.mycampus.Server.Entity.Response;
import com.mycampus.Server.Repository.Branch;
import com.mycampus.Server.Repository.Dept;
import com.mycampus.Server.Repository.UserRepo;
import com.mycampus.Server.Util.MyCampusUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    private static Logger MCLogger = LogManager.getLogger(BranchService.class);

    @Autowired
    private Dept deptRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Branch branchRepo;

    public Response addBranch(BranchRegistration branch){
        String methodName = "addBranch";
        Response response = new Response();
        try{
            if(branchRepo.existsByBranchName(branch.getBranchName()) || branchRepo.existsByBranchCode(branch.getBranchCode())){
                MCLogger.error(methodName+" Branch Already Exists");
                MyCampusUtil.failureResponse(response, MyCampusConst.EXISTING_ENTRY);
            }
            else{
                branchRepo.save(branch);
                MCLogger.info(methodName+" Branch added successfully");
                MyCampusUtil.successResponse(response);
            }
        }
        catch (Exception e){
            MCLogger.error(methodName+" Error while adding new branch ",e);
            MyCampusUtil.failureResponse(response,MyCampusConst.UNKNOWN_ERROR);
        }
        MCLogger.info(methodName+" Add Branch response from server"+response);
        return response;
    }
}
