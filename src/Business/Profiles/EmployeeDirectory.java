/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Business;
import Business.Person.Person;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kal bugrara
 */
public class EmployeeDirectory {

    Business business;
    ArrayList<EmployeeProfile> employeelist;

    public EmployeeDirectory(Business d) {

        business = d;
        employeelist = new ArrayList();

    }

    public EmployeeProfile newEmployeeProfile(Person p, String department, String jobTitle, Date hireDate) {

        EmployeeProfile ep = new EmployeeProfile(p, department, jobTitle, hireDate);
        employeelist.add(ep);
        return ep;
    }

    public EmployeeProfile findEmployee(String id) {

        for (EmployeeProfile sp : employeelist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }

    public ArrayList<EmployeeProfile> getEmployeeList() {
        return employeelist;
    }

}
