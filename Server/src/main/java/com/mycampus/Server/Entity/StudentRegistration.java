package com.mycampus.Server.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentRegistration {
    @Id
    @Column(name = "srn")
    private String srn;

    @Column(name = "username")
    private long username;

    @Column(name = "Faculty_Verification")
    private int facultyVerification;

    @Column(name = "Mode_of_Admission")
    private String modeOfAdmission;

    @Column(name = "Father_Name")
    private String fatherName;

    @Column(name = "Mother_Name")
    private String motherName;

    @Column(name = "Course_Opted")
    private String courseOpted;

    @Column(name = "Dept_Id")
    private long deptId;

    @Column(name = "Branch_Id")
    private long branchId;

    @Column(name = "Section")
    private String section;

    @Column(name = "Class_Teacher_Username")
    private long classTeacherUsername;

    @Column(name = "Mentor_Username")
    private long mentorUsername;

    @Column(name = "Parent_Contact")
    private long parentMobileNo;

    @Column(name = "Parent_MailId")
    private String parentMailId;

    @Column(name = "X_Class_Marks")
    private float xClassMarks;

    @Column(name = "X_Class_Passing_Year")
    private int xPassingYear;

    @Column(name = "X_Class_School")
    private String xClassSchool;

    @Column(name = "X_Class_Registration_No")
    private String xClassRegistrationNo;

    @Column(name = "X_Class_Board")
    private String xClassBoard;

    @Column(name = "X_Class_State")
    private String xClassState;

    @Column(name = "XII_Class_Marks")
    private float xiiClassMarks;

    @Column(name = "XII_Class_Passing_Year")
    private int xiiPassingYear;

    @Column(name = "XII_Class_School")
    private String xiiClassSchool;

    @Column(name = "XII_Class_Registration_No")
    private String xiiClassRegistrationNo;

    @Column(name = "XII_Class_Board")
    private String xiiClassBoard;

    @Column(name = "XII_Class_State")
    private String xiiClassState;

    @Column(name = "Aadhar_No")
    private long aadharNo;

    @Column(name = "Pan_Card_No")
    private String panCardNo;

    @Column(name = "Ug_Regitration_Number")
    private String ugRegistrationNo;

    @Column(name = "Ug_Marks")
    private float ugMarks;

    @Column(name = "Ug_College")
    private String ugCollege;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "Address")
    private String address;

    @Column(name = "Verified_By")
    private long verifiedBy;

    @Column(name = "Amount_To_Be_Paid")
    private long amoutToBePaid;

    @Column(name = "Amount_Paid")
    private long amountPaid;

    @Column(name = "Qualifying_Exam_Score")
    private int qualifyingExamScore;

    @Column(name = "Validation_Remarks")
    private String validationRemarks;

    @Column(name = "Date_of_Joining")
    private long dateOfJoining;

    @Column(name = "Date_of_Completion")
    private long dateOfCompletion;

    public long getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(long dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public long getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(long dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    public long getUsername() {
        return username;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    public int getFacultyVerification() {
        return facultyVerification;
    }

    public void setFacultyVerification(int facultyVerification) {
        this.facultyVerification = facultyVerification;
    }

    public String getModeOfAdmission() {
        return modeOfAdmission;
    }

    public void setModeOfAdmission(String modeOfAdmission) {
        this.modeOfAdmission = modeOfAdmission;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getCourseOpted() {
        return courseOpted;
    }

    public void setCourseOpted(String courseOpted) {
        this.courseOpted = courseOpted;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public long getClassTeacherUsername() {
        return classTeacherUsername;
    }

    public void setClassTeacherUsername(long classTeacherUsername) {
        this.classTeacherUsername = classTeacherUsername;
    }

    public long getMentorUsername() {
        return mentorUsername;
    }

    public void setMentorUsername(long mentorUsername) {
        this.mentorUsername = mentorUsername;
    }

    public long getParentMobileNo() {
        return parentMobileNo;
    }

    public void setParentMobileNo(long parentMobileNo) {
        this.parentMobileNo = parentMobileNo;
    }

    public String getParentMailId() {
        return parentMailId;
    }

    public void setParentMailId(String parentMailId) {
        this.parentMailId = parentMailId;
    }

    public float getxClassMarks() {
        return xClassMarks;
    }

    public void setxClassMarks(float xClassMarks) {
        this.xClassMarks = xClassMarks;
    }

    public int getxPassingYear() {
        return xPassingYear;
    }

    public void setxPassingYear(int xPassingYear) {
        this.xPassingYear = xPassingYear;
    }

    public String getxClassSchool() {
        return xClassSchool;
    }

    public void setxClassSchool(String xClassSchool) {
        this.xClassSchool = xClassSchool;
    }

    public String getxClassRegistrationNo() {
        return xClassRegistrationNo;
    }

    public void setxClassRegistrationNo(String xClassRegistrationNo) {
        this.xClassRegistrationNo = xClassRegistrationNo;
    }

    public String getxClassBoard() {
        return xClassBoard;
    }

    public void setxClassBoard(String xClassBoard) {
        this.xClassBoard = xClassBoard;
    }

    public String getxClassState() {
        return xClassState;
    }

    public void setxClassState(String xClassState) {
        this.xClassState = xClassState;
    }

    public float getXiiClassMarks() {
        return xiiClassMarks;
    }

    public void setXiiClassMarks(float xiiClassMarks) {
        this.xiiClassMarks = xiiClassMarks;
    }

    public int getXiiPassingYear() {
        return xiiPassingYear;
    }

    public void setXiiPassingYear(int xiiPassingYear) {
        this.xiiPassingYear = xiiPassingYear;
    }

    public String getXiiClassSchool() {
        return xiiClassSchool;
    }

    public void setXiiClassSchool(String xiiClassSchool) {
        this.xiiClassSchool = xiiClassSchool;
    }

    public String getXiiClassRegistrationNo() {
        return xiiClassRegistrationNo;
    }

    public void setXiiClassRegistrationNo(String xiiClassRegistrationNo) {
        this.xiiClassRegistrationNo = xiiClassRegistrationNo;
    }

    public String getXiiClassBoard() {
        return xiiClassBoard;
    }

    public void setXiiClassBoard(String xiiClassBoard) {
        this.xiiClassBoard = xiiClassBoard;
    }

    public String getXiiClassState() {
        return xiiClassState;
    }

    public void setXiiClassState(String xiiClassState) {
        this.xiiClassState = xiiClassState;
    }

    public long getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(long aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPanCardNo() {
        return panCardNo;
    }

    public void setPanCardNo(String panCardNo) {
        this.panCardNo = panCardNo;
    }

    public String getUgRegistrationNo() {
        return ugRegistrationNo;
    }

    public void setUgRegistrationNo(String ugRegistrationNo) {
        this.ugRegistrationNo = ugRegistrationNo;
    }

    public float getUgMarks() {
        return ugMarks;
    }

    public void setUgMarks(float ugMarks) {
        this.ugMarks = ugMarks;
    }

    public String getUgCollege() {
        return ugCollege;
    }

    public void setUgCollege(String ugCollege) {
        this.ugCollege = ugCollege;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(long verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public long getAmoutToBePaid() {
        return amoutToBePaid;
    }

    public void setAmoutToBePaid(long amoutToBePaid) {
        this.amoutToBePaid = amoutToBePaid;
    }

    public long getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getQualifyingExamScore() {
        return qualifyingExamScore;
    }

    public void setQualifyingExamScore(int qualifyingExamScore) {
        this.qualifyingExamScore = qualifyingExamScore;
    }

    public String getValidationRemarks() {
        return validationRemarks;
    }

    public void setValidationRemarks(String validationRemarks) {
        this.validationRemarks = validationRemarks;
    }

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    @Override
    public String toString() {
        return "StudentRegistration{" +
                "srn='" + srn + '\'' +
                ", username=" + username +
                ", facultyVerification=" + facultyVerification +
                ", modeOfAdmission='" + modeOfAdmission + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", courseOpted='" + courseOpted + '\'' +
                ", deptId=" + deptId +
                ", branchId=" + branchId +
                ", section='" + section + '\'' +
                ", classTeacherUsername=" + classTeacherUsername +
                ", mentorUsername=" + mentorUsername +
                ", parentMobileNo=" + parentMobileNo +
                ", parentMailId='" + parentMailId + '\'' +
                ", xClassMarks=" + xClassMarks +
                ", xPassingYear=" + xPassingYear +
                ", xClassSchool='" + xClassSchool + '\'' +
                ", xClassRegistrationNo='" + xClassRegistrationNo + '\'' +
                ", xClassBoard='" + xClassBoard + '\'' +
                ", xClassState='" + xClassState + '\'' +
                ", xiiClassMarks=" + xiiClassMarks +
                ", xiiPassingYear=" + xiiPassingYear +
                ", xiiClassSchool='" + xiiClassSchool + '\'' +
                ", xiiClassRegistrationNo='" + xiiClassRegistrationNo + '\'' +
                ", xiiClassBoard='" + xiiClassBoard + '\'' +
                ", xiiClassState='" + xiiClassState + '\'' +
                ", aadharNo=" + aadharNo +
                ", panCardNo='" + panCardNo + '\'' +
                ", ugRegistrationNo='" + ugRegistrationNo + '\'' +
                ", ugMarks=" + ugMarks +
                ", ugCollege='" + ugCollege + '\'' +
                ", nationality='" + nationality + '\'' +
                ", address='" + address + '\'' +
                ", verifiedBy=" + verifiedBy +
                ", amoutToBePaid=" + amoutToBePaid +
                ", amountPaid=" + amountPaid +
                ", qualifyingExamScore=" + qualifyingExamScore +
                ", validationRemarks='" + validationRemarks + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", dateOfCompletion=" + dateOfCompletion +
                '}';
    }
}
