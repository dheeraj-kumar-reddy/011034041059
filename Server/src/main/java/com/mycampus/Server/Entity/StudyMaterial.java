package com.mycampus.Server.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Study_material")
public class StudyMaterial {
    @Column(name = "Book_Name")
    private String bookName;

    @Id
    @Column(name = "Book_No")
    private String bookNo;

    @Column(name = "Book_Link")
    private String bookLink;

    @Column(name = "Dept_id")
    private long deptId;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookLink() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "StudyMaterial{" +
                "bookName='" + bookName + '\'' +
                ", bookNo='" + bookNo + '\'' +
                ", bookLink='" + bookLink + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
