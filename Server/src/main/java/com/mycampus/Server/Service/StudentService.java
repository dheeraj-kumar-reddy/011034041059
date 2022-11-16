package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.OnJoiningResponse;
import com.mycampus.Server.Entity.Response;
import com.mycampus.Server.Entity.StudentRegistration;
import com.mycampus.Server.Entity.User;
import com.mycampus.Server.MyCampusConfigProperties;
import com.mycampus.Server.Repository.Student;
import com.mycampus.Server.Repository.UserRepo;
import com.mycampus.Server.Util.MyCampusUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    private static Logger MCLogger = LogManager.getLogger(StudentService.class);

    @Autowired
    private Student studentRepo;

    @Autowired
    private UserRepo userRepo;

    public OnJoiningResponse onStudentJoining(StudentRegistration student){
        String methodName = "onStudentJoining";
        OnJoiningResponse response = new OnJoiningResponse();
        long username = student.getUsername();
        try {
            User user = userRepo.findById(username).get();
            if (userRepo.existsByUsernameAndAdmissionStatus(username, MyCampusConst.ADMISSION_CONFIRMED)){
                MCLogger.error(methodName+" User already admitted");
                MyCampusUtil.studentJoinFailed(response,MyCampusConst.EXISTING_ENTRY);
            }
            else{

            }
        }
        catch (NoSuchElementException e){
            MCLogger.error(methodName+" User not found with username: "+username,e);
            MyCampusUtil.studentJoinFailed(response, MyCampusConst.INVALID_ENTRY);
        }
        catch (Exception e){
            MCLogger.error(methodName+" Error occurred while admitting student",e);
            MyCampusUtil.studentJoinFailed(response,MyCampusConst.UNKNOWN_ERROR);
        }
        MCLogger.info(methodName+" Student Admission Response from Server: "+response);
        return response;
    }

    public ResponseEntity downloadFile(String filename, String typeOfDocument){
        String methodName = "downloadFile";
        String filePath = MyCampusUtil.getFilePath(typeOfDocument,filename);
        MCLogger.info(methodName+" File Path: "+filePath);
        File file = new File(filePath);
        InputStreamResource resource = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add("Content-Disposition",String.format("attachment; filename=\"%s\"",filename));
            resource = new InputStreamResource(new FileInputStream(file));
        }
        catch (FileNotFoundException e){
            MCLogger.error(methodName+" File not found "+filename,e);
        }
        catch (Exception e){
            MCLogger.error(methodName+" Exception occurred while downloading the file, "+filename);
        }
        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE))
                .body(resource);
    }

    public Response uploadFile(MultipartFile file, String filename, String typeOfDocument){
        String methodName = "uploadFile";
        Path fileStorageLocation = MyCampusUtil.getFileStorageLocation(typeOfDocument);
        Response response = new Response();
        if(file.getSize() > MyCampusConst.MAX_FILE_SIZE){
            MCLogger.error(methodName+" File size limit exceeded");
            MyCampusUtil.failureResponse(response,MyCampusConst.INVALID_ENTRY);
            return response;
        }
        String actualFileName = file.getOriginalFilename();
        String actualFileNameExtension = actualFileName.substring(actualFileName.lastIndexOf(MyCampusConst.FILE_EXTENSION_SEPARATOR));
        if(!actualFileNameExtension.equals(MyCampusConst.PDF_FILE_EXTENSION)){
            MCLogger.error(methodName+" Invalid file format uploaded, only pdf allowed, uploaded "+actualFileNameExtension);
            MyCampusUtil.failureResponse(response,MyCampusConst.INVALID_CREDENTIALS);
            return response;
        }
        MCLogger.info(methodName+" File Path: "+fileStorageLocation.toString()+"\\"+filename);
        try{
            InputStream fileInputStream = file.getInputStream();
            Path filePathLocation = fileStorageLocation.resolve(filename);
            Files.copy(fileInputStream, filePathLocation, StandardCopyOption.REPLACE_EXISTING);
            MyCampusUtil.successResponse(response);
            MCLogger.info(methodName+" File uploaded successfully");
        } catch (IOException e) {
            MCLogger.error(methodName+" Error while uploading the file",e);
            MyCampusUtil.failureResponse(response,MyCampusConst.UNKNOWN_ERROR);
        } catch (Exception e) {
            MCLogger.error(methodName+" Error while uploading the file",e);
            MyCampusUtil.failureResponse(response,MyCampusConst.UNKNOWN_ERROR);
        }
        return response;
    }
}
