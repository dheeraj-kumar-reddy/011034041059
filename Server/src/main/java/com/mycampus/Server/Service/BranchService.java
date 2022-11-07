package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.BranchRegistration;
import com.mycampus.Server.Entity.BranchToUI;
import com.mycampus.Server.Entity.Response;
import com.mycampus.Server.Repository.Branch;
import com.mycampus.Server.Repository.Dept;
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

    public List<BranchToUI> getAllBranches(){
        String methodName = "getAllBranches";
        List<BranchToUI> branchToUIList = new ArrayList<>();
        try{
            MCLogger.info(methodName+" Retrieving branch details from server");
            List<BranchRegistration> branchList = branchRepo.findAll();
            if(branchList.isEmpty()){
                MCLogger.error(methodName+" No branches available");
                return branchToUIList;
            }
            else{
                for(BranchRegistration branchRegistration : branchList){
                    BranchToUI branchToUI = updateBranchToUI(branchRegistration);
                    branchToUIList.add(branchToUI);
                }
            }
        }
        catch (Exception e){
            MCLogger.error(methodName+" Exception occurred while retrieving branch details from server");
        }
        return branchToUIList;
    }

    private BranchToUI updateBranchToUI(BranchRegistration branchRegistration) throws Exception{
        String methodName = "updateBranchToUI";
        BranchToUI branchToUI = new BranchToUI();
        branchToUI.setBranchId(branchRegistration.getBranchId());
        branchToUI.setBranchName(branchRegistration.getBranchName());
        branchToUI.setBranchCode(branchRegistration.getBranchCode());
        branchToUI.setDeptId(branchRegistration.getDeptId());
        branchToUI.setFeeForCet(branchRegistration.getFeeForCet());
        branchToUI.setFeeForComedk(branchRegistration.getFeeForComedk());
        branchToUI.setFeeForUQ(branchRegistration.getFeeForUQ());
        branchToUI.setTotalSeatsAvailable(branchRegistration.getTotalSeatsAvailable());
        branchToUI.setSeatsBooked(branchRegistration.getSeatsBooked());
        try{
            branchToUI.setHodName(userRepo.findById(branchRegistration.getHodUsername()).get().getName());
        }
        catch (NoSuchElementException e){
            MCLogger.error(methodName+" HOD not found",e);
            throw e;
        }
        catch(Exception e){
            MCLogger.error(methodName+" Exception occurred while retrieving HOD name");
            throw e;
        }
        return branchToUI;
    }
}
