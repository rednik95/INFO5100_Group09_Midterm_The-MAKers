/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kal bugrara
 */
public class FacultyDirectory {

    ArrayList<FacultyProfile> facultylist;

    public FacultyDirectory() {

        facultylist = new ArrayList();

    }

    public FacultyProfile newFacultyProfile(Person p, String department, String subject, Date hireDate) {

        FacultyProfile fp = new FacultyProfile(p, department, subject, hireDate);
        facultylist.add(fp);
        return fp;
    }

    public FacultyProfile findFaculty(String id) {

        for (FacultyProfile sp : facultylist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }

    public ArrayList<FacultyProfile> getFacultyList() {
        return facultylist;
    }

}
