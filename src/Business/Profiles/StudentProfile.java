/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import UserInterface.AppUtils.AppUtils;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile {

    private String nuid;
    private String major;
    private String activationCode;

    /*   public StudentProfile(Person p) {
        super(p);
    }*/
    public StudentProfile(Person p, String nuid, String major) {
        super(p);
        this.nuid = nuid;
        this.major = major;
    }

    @Override
    public String getRole() {
        return AppUtils.ROLE_STUDENT;
    }

    @Override
    public String toString() {
        return getPerson().getPersonId();
    }

    public String getNuid() {
        return nuid;
    }

    public void setNuid(String nuid) {
        this.nuid = nuid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public void clearActivationCode() {
        this.activationCode = null;
    }
}
