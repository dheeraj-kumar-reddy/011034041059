package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.Department;
import com.mycampus.Server.Entity.DepartmentListToUI;
import com.mycampus.Server.Entity.Response;
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
public class DepartmentService {
    private static Logger MCLogger= LogManager.getLogger(DepartmentService.class);
    @Autowired
    private Dept departmentRepo;

    @Autowired
    private UserRepo userRepo;

    public Response addDepartment(Department department){
        String methodName = "addDepartment";
        Response response = new Response();
        try{
            if(departmentRepo.existsByDeptName(department.getDeptName()) || departmentRepo.existsByDeptCode(department.getDeptCode())){
                MCLogger.error(methodName+" Department Already Exists");
                MyCampusUtil.failureResponse(response, MyCampusConst.EXISTING_ENTRY);
            }
            else{
                departmentRepo.save(department);
                MCLogger.info(methodName+" Department added successfully");
                MyCampusUtil.successResponse(response);
            }
        }
        catch (Exception e){
            MCLogger.error(methodName+" Error while adding New Department ",e);
            MyCampusUtil.failureResponse(response,MyCampusConst.UNKNOWN_ERROR);
        }
        MCLogger.info(methodName+" Add Department response from server"+response);
        return response;
    }

    public List<DepartmentListToUI> getAllDepartments(){
        String methodName = "getAllDepartments";
        List<DepartmentListToUI> departmentListToUI = new ArrayList<>();
        try{
            MCLogger.info(methodName+" Retrieving all departments from server");
            List<Department> departmentList = departmentRepo.findAll();
            if(departmentList.isEmpty()){
                MCLogger.info(methodName+" No departments available");
                return departmentListToUI;
            }
            else {
                for (Department department : departmentList) {
                    DepartmentListToUI departmentListToUI1 = updateDepartmentListToUI(department);
                    departmentListToUI.add(departmentListToUI1);
                }
            }
        }
        catch (Exception e){
            MCLogger.error(methodName+" Exception occurred while retrieving all departments from server",e);
        }
        MCLogger.info(methodName+" All department details retrieved successfully");
        return departmentListToUI;
    }

    private DepartmentListToUI updateDepartmentListToUI(Department department) throws Exception{
        String methodName = "updateDepartmentListToUI";
        DepartmentListToUI departmentListToUI = new DepartmentListToUI();
        departmentListToUI.setDeptId(department.getDeptId());
        departmentListToUI.setDeptName(department.getDeptName());
        departmentListToUI.setDeptCode(department.getDeptCode());
        try {
            departmentListToUI.setDirectorName(userRepo.findById(department.getDirectorUsername()).get().getName());
            departmentListToUI.setAsstDirectorName(userRepo.findById(department.getAssDirectorUsername()).get().getName());
        }
        catch (NoSuchElementException e){
            MCLogger.error(methodName+" Director and assistant director details not found");
            throw e;
        }
        catch (Exception e){
            MCLogger.error(methodName+" Exception occurred while retrieving director and assistant director name");
            throw e;
        }
        return departmentListToUI;
    }
}
