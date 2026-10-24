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
public class EmployeeProfile extends Profile {

    String department;
    String jobTitle;
    Date hireDate;

 /*   public EmployeeProfile(Person p) {

        super(p);

    }*/

    public EmployeeProfile(Person p, String department, String jobTitle, Date hireDate) {
        super(p);
        this.department = department;
        this.jobTitle = jobTitle;
        this.hireDate = hireDate;
    }

    @Override
    public String getRole() {
        return AppUtils.ROLE_ADMIN;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

}
