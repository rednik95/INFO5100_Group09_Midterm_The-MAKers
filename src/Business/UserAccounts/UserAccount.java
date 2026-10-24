/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import UserInterface.AppUtils.AppUtils;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {

    Profile profile;
    String username;
    String password;
    Boolean status;
    Date lastActivity;
    Date lastUpdate;

    public UserAccount(Profile profile, String un, String pw, Boolean status, Date lastActivity, Date lastUpdate) {
        username = un;
        password = pw;
        this.profile = profile;
        this.status = status;
        this.lastActivity = lastActivity;
        this.lastUpdate = lastUpdate;

    }

    public String getPersonId() {
        return profile.getPerson().getPersonId();
    }

    public String getUserLoginName() {
        return username;
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public boolean IsValidUser(String un, String pw) {

        if (username.equalsIgnoreCase(un) && password.equals(pw)) {
            return true;
        } else {
            return false;
        }

    }

    public String getRole() {
        return profile.getRole();
    }

    public Profile getAssociatedPersonProfile() {
        return profile;
    }

    @Override
    public String toString() {

        return getUserLoginName();
    }

    public String getStatus() {
        if (status == true) {
            return AppUtils.STATUS_ACTIVE;
        }
        return AppUtils.STATUS_INACTIVE;
    }

    public String getLastUpdated() {

        return AppUtils.formatDate(lastUpdate);

    }

    public String getLastActivity() {

        return AppUtils.formatDate(lastActivity);

    }
    
    

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
