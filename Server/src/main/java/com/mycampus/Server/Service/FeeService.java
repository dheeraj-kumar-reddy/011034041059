package com.mycampus.Server.Service;

import com.mycampus.Server.Const.MyCampusConst;
import com.mycampus.Server.Entity.FeePayment;
import com.mycampus.Server.Entity.FeePaymentResponse;
import com.mycampus.Server.Repository.Fee;
import com.mycampus.Server.Util.MyCampusUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeService {
    private static Logger MCLogger = LogManager.getLogger(FeeService.class);

    @Autowired
    private Fee feeRepo;

    public FeePaymentResponse generateFeeReceipt(FeePayment feePayment){
        String methodName = "generateFeeReceipt";
        FeePaymentResponse response = new FeePaymentResponse();
        try{
            feePayment.setPaymentDate(System.currentTimeMillis());
            feeRepo.save(feePayment);
            if(feePayment.getPaymentStatus() == MyCampusConst.FAILURE){
                MCLogger.error(methodName+" Payment Failed");
                MyCampusUtil.failurePaymentResponse(response,feePayment);
            }
            else{
                MCLogger.info(methodName+" Payment Success");
                MyCampusUtil.successPaymentResponse(response,feePayment);
            }
        }
        catch (Exception e){
            MCLogger.error(methodName+" Error while generating fee receipt",e);
            MyCampusUtil.failurePaymentResponse(response, feePayment);
        }
        return response;
    }
}
