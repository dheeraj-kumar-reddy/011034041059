package com.mycampus.Server.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentRegistration {
    @Id
    @Column(name = "srn")
    private String srn;

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
                '}';
    }
}
