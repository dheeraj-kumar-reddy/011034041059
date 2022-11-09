package com.mycampus.Server;

import com.mycampus.Server.Const.MyCampusConst;
import org.springframework.stereotype.Component;

import java.util.Properties;

public class MyCampusConfigProperties {
    public static String tenthMarksSheetDirectory;
    public static String pucMarksSheetDirectory;
    public static String ugMarksSheetDirectory;
    public static String tcDirectory;

    public static String otherDocumentsDirectory;

    public MyCampusConfigProperties(Properties properties){
        tenthMarksSheetDirectory = properties.getProperty(MyCampusConst.TENTH_MARKS_SHEET_DIRECTORY);
        pucMarksSheetDirectory = properties.getProperty(MyCampusConst.PUC_MARKS_SHEET_DIRECTORY);
        ugMarksSheetDirectory = properties.getProperty(MyCampusConst.UG_MARKS_SHEET_DIRECTORY);
        tcDirectory = properties.getProperty(MyCampusConst.TC_DIRECTORY);
        otherDocumentsDirectory = properties.getProperty(MyCampusConst.OTHER_DOCUMENTS_DIRECTORY);
    }

    public static String getTenthMarksSheetDirectory() {
        return tenthMarksSheetDirectory;
    }

    public static void setTenthMarksSheetDirectory(String tenthMarksSheetDirectory) {
        MyCampusConfigProperties.tenthMarksSheetDirectory = tenthMarksSheetDirectory;
    }

    public static String getPucMarksSheetDirectory() {
        return pucMarksSheetDirectory;
    }

    public static void setPucMarksSheetDirectory(String pucMarksSheetDirectory) {
        MyCampusConfigProperties.pucMarksSheetDirectory = pucMarksSheetDirectory;
    }

    public static String getUgMarksSheetDirectory() {
        return ugMarksSheetDirectory;
    }

    public static void setUgMarksSheetDirectory(String ugMarksSheetDirectory) {
        MyCampusConfigProperties.ugMarksSheetDirectory = ugMarksSheetDirectory;
    }

    public static String getTcDirectory() {
        return tcDirectory;
    }

    public static void setTcDirectory(String tcDirectory) {
        MyCampusConfigProperties.tcDirectory = tcDirectory;
    }

    public static String getOtherDocumentsDirectory() {
        return otherDocumentsDirectory;
    }

    public static void setOtherDocumentsDirectory(String otherDocumentsDirectory) {
        MyCampusConfigProperties.otherDocumentsDirectory = otherDocumentsDirectory;
    }

}
