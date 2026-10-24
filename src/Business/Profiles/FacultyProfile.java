/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import UserInterface.AppUtils.AppUtils;
import java.util.Date;

/**
 *
 * @author kal bugrara
 */
public class FacultyProfile extends Profile {

//    Transcript transcript;
    //   EmploymentHistroy employmenthistory;
    private String department;
    private String subject;
    private Date hireDate;

    /*   public FacultyProfile(Person p) {
        super(p);

//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }*/
    public FacultyProfile(Person p, String department, String subject, Date hireDate) {
        super(p);
        this.department = department;
        this.subject = subject;
        this.hireDate = hireDate;
    }

    @Override
    public String getRole() {
        return AppUtils.ROLE_FACULTY;
    }

    @Override
    public String toString() {
        return getPerson().getPersonId();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

}
