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
    public static final int SUCCESS = 1;

    public static final int FAILURE = 2;

    //Error codes
    public static final int EXISTING_ENTRY = 1;

    public static final int INVALID_CREDENTIALS = 2;

    public static final int UNKNOWN_ERROR = -1;

}
