package com.mycampus.Server.Const;

public class MyCampusConst {
    //Admission related
    public static final int FACULTY_ADMISSION = 0;

    public static final int ADMISSION_NOT_YET_CONFIRMED = 1;

    public static final int ADMISSION_CONFIRMED = 2;

    //Gender related
    public static final int GENDER_MALE = 1;

    public static final int GENDER_FEMALE = 2;

    public static final int GENDER_OTHERS = 3;

    //Verification related
    public static final int VERIFICATION_PENDING = 0;

    public static final int VERIFICATION_SUCCESSFUL = 1;

    //User related
    public static final int STUDENT_USER = 1;

    public static final int ADMIN_USER = 2;

    public static final int TEACHING_FACULTY_USER = 3;

    public static final int SUPER_USER = 4;

    //Account status related
    public static final int ACCOUNT_ACTIVE = 1;

    public static final int ACCOUNT_LOGGED_IN = 2;

    //Status
    public static final int SUCCESS = 0;

    public static final int FAILURE = 1;

    //Verification
    public static final int USER_VERIFICATION_SUCCESS = 0;

    public static final int USER_VERIFICATION_FAILURE = 1;

    //Error codes
    public static final int EXISTING_ENTRY = 1;

    public static final int INVALID_CREDENTIALS = 2;

    public static final int UNKNOWN_ERROR = -1;

    public static final int INVALID_ENTRY = 3;

    public static final int NO_ERROR = 0;

    public static final int UNVERIFIED_USER = 4;

    public static final int INVALID_ROLE = -1;

    public static final long INVALID_USERNAME = -1;

    public static final String SPACE = " ";

    public static final String HIDDEN_PASSWORD = "XXXXXXXX";

    public static final String INVALID_ID = "null";

    public static final String REPLACE_USERNAME = "#username#";

    public static final String X_MARKS_SHEET_FORMAT = "#username#_tenth_marks_sheet.pdf";

    public static final String PUC_MARKS_SHEET_FORMAT = "#username#_puc_marks_sheet.pdf";

    public static final String UG_MARKS_SHEET_FORMAT = "#username#_ug_marks_sheet.pdf";

    public static final String TC_FORMAT = "#username#_tc.pdf";

    public static final String OTHER_DOC_FORMAT = "#username#_other_doc.pdf";

    public static final String ROOT_DIR = System.getenv("MY_CAMPUS_DIR");

    public static final String PROPERTIES_FILE_PATH = ROOT_DIR+"\\011034041059\\bin\\MyCampus.properties";

    //Properties Related
    public static final String TENTH_MARKS_SHEET_DIRECTORY = "TENTH_MARKS_SHEET_DIRECTORY";

    public static final String PUC_MARKS_SHEET_DIRECTORY = "PUC_MARKS_SHEET_DIRECTORY";

    public static final String UG_MARKS_SHEET_DIRECTORY = "UG_MARKS_SHEET_DIRECTORY";

    public static final String TC_DIRECTORY = "TC_DIRECTORY";

    public static final String OTHER_DOCUMENTS_DIRECTORY = "OTHER_DOCUMENTS_DIRECTORY";

    public static final String TENTH = "tenth";

    public static final String PUC = "puc";

    public static final String UG = "ug";

    public static final String TC = "tc";

    public static final String OTHER_DOCUMENT = "od";

    public static final long MAX_FILE_SIZE = 5242880;

    public static final String FILE_EXTENSION_SEPARATOR = ".";

    public static final String PDF_FILE_EXTENSION = ".pdf";
}
