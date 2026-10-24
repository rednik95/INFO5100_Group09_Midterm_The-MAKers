/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import UserInterface.AppUtils.AppUtils;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {

    ArrayList<UserAccount> useraccountlist;

    public UserAccountDirectory() {

        useraccountlist = new ArrayList();

    }

    public UserAccount newUserAccount(Profile p, String un, String pw, Boolean status, Date lastActivity, Date lastUpdate) {

        UserAccount ua = new UserAccount(p, un, pw, status, lastActivity, lastUpdate);
        useraccountlist.add(ua);
        return ua;
    }

    public UserAccount findUserAccount(String id) {

        for (UserAccount ua : useraccountlist) {

            if (ua.isMatch(id)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    public UserAccount AuthenticateUser(String un, String pw) {

        for (UserAccount ua : useraccountlist) {

            if (ua.IsValidUser(un, pw)
                    && AppUtils.STATUS_ACTIVE.equals(ua.getStatus())) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return useraccountlist;
    }
    
    public boolean usernameExists(String username, UserAccount excludedAccount) {

    for (UserAccount ua : useraccountlist) {
        if (ua != excludedAccount
                && ua.getUserLoginName().equalsIgnoreCase(username)) {
            return true;
        }
    }

    return false;
}
}
