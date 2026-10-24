/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

// Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization  
        Person person001 = persondirectory.newPerson("John", "Smith", "john.smith@example.com", "2025550101");
        Person person002 = persondirectory.newPerson("Gina", "Montana", "gina.montana@example.com", "2025550102");
        Person person003 = persondirectory.newPerson("Adam", "Rollen", "adam.rollen@example.com", "2025550103");

        Person person005 = persondirectory.newPerson("Jim", "Dellon", "jim.dellon@example.com", "2025550105");
        Person person006 = persondirectory.newPerson("Anna", "Shnider", "anna.shnider@example.com", "2025550106");
        Person person007 = persondirectory.newPerson("Laura", "Brown", "laura.brown@example.com", "2025550107");
        Person person008 = persondirectory.newPerson("Jack", "While", "jack.while@example.com", "2025550108");
        Person person009 = persondirectory.newPerson("Fidelity", "", "contact@example.com", "2025550109"); // Customer

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(
                person001,
                "IT",
                "System Administrator",
                new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime()
        );

        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(
                person003,
                "002345678",
                "Information Systems"
        );

        FacultyDirectory facultydirectory = business.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(
                person006,
                "Computer Science",
                "Database Management",
                new GregorianCalendar(2023, Calendar.JANUARY, 15).getTime()
        );

// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(
                employeeprofile0, "admin",
                "****",
                true,
                new GregorianCalendar(2026, Calendar.MAY, 17, 8, 30).getTime(),
                new GregorianCalendar(2026, Calendar.MAY, 17, 8, 30).getTime()); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(
                studentprofile0, "adam",
                "****",
                true,
                new GregorianCalendar(2026, Calendar.SEPTEMBER, 15, 14, 30).getTime(),
                new GregorianCalendar(2026, Calendar.SEPTEMBER, 15, 14, 30).getTime()); /// order products for one of the customers and performed by a sales person

        UserAccount ua5 = uadirectory.newUserAccount(
                facultyprofile0, "Anna",
                "****",
                true,
                new GregorianCalendar(2026, Calendar.SEPTEMBER, 15, 14, 30).getTime(),
                new GregorianCalendar(2026, Calendar.SEPTEMBER, 15, 14, 30).getTime()); /// order products for one of the customers and performed by a sales person

        return business;

    }

}
