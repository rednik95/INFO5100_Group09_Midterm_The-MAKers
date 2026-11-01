/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona;

import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.SeatAssignment;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Transcript {

    StudentProfile student;
    HashMap<String, CourseLoad> courseloadlist;

    CourseLoad currentcourseload;

    public Transcript(StudentProfile sp) {
        student = sp;
        courseloadlist = new HashMap();

    }

    public int getStudentSatisfactionIndex() {
        //for each courseload 
        //get seatassigmnets; 
        //for each seatassignment add 1 if like =true;
        return 0;
    }

    public CourseLoad newCourseLoad(String sem) {

        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }

    public CourseLoad getCurrentCourseLoad() {

        return currentcourseload;

    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return courseloadlist.get(semester);

    }

    public float getStudentTotalScore() {

        float sum = 0;

        for (CourseLoad cl : courseloadlist.values()) {
            sum = sum + cl.getSemesterScore();

        }
        return sum;
    }

    //sat index means student rated their courses with likes;
    public int getStudentSatifactionIndex() {
        ArrayList<SeatAssignment> courseregistrations = getCourseList();
        int sum = 0;
        for (SeatAssignment sa : courseregistrations) {

            if (sa.getLike()) {
                sum = sum + 1;
            }
        }
        return sum;
    }
    //generate a list of all courses taken so far (seetassignments) 
    //from multiple semesters (course loads)
    //from seat assignments we will be able to access the course offers

    public ArrayList<SeatAssignment> getCourseList() {
        ArrayList temp2;
        temp2 = new ArrayList();

        for (CourseLoad cl : courseloadlist.values()) { //extract cl list as objects --ignore label
            temp2.addAll(cl.getSeatAssignments()); //merge one array list to another
        }

        return temp2;

    }

    /**
     * Calculates the cumulative GPA using graded courses only. Each grade is
     * weighted by the course credit hours.
     *
     * @author Astrid Noizillier
     */
    public double calculateGPA() {
        double totalGradePoints = 0;
        int gradedCredits = 0;

        for (SeatAssignment sa : getCourseList()) {
            if (sa == null || !sa.isGraded()) {
                continue;
            }

            int credits = sa.getCreditHours();
            totalGradePoints += sa.getGrade() * credits;
            gradedCredits += credits;
        }

        if (gradedCredits == 0) {
            return 0.0;
        }

        return totalGradePoints / gradedCredits;
    }

    /**
     * Returns credits earned from graded courses. Assumes that a positive grade
     * represents a passed course.
     *
     * @author Astrid Noizillier
     */
    public int getEarnedCredits() {
        int credits = 0;

        for (SeatAssignment sa : getCourseList()) {
            if (sa != null && sa.isGraded()
                    && sa.getGrade() > 0) {
                credits += sa.getCreditHours();
            }
        }

        return credits;
    }

    /**
     * Returns credits for all enrolled courses.
     *
     * @author Astrid Noizillier
     */
    public int getTotalEnrolledCredits() {
        int credits = 0;

        for (SeatAssignment sa : getCourseList()) {
            if (sa != null) {
                credits += sa.getCreditHours();
            }
        }

        return credits;
    }

    /**
     * Counts courses that have received a grade.
     *
     * @author Astrid Noizillier
     */
    public int getCompletedCoursesCount() {
        int count = 0;

        for (SeatAssignment sa : getCourseList()) {
            if (sa != null && sa.isGraded()) {
                count++;
            }
        }

        return count;
    }

    /**
     * Determines academic standing using a simplified graduate GPA requirement
     * of 3.00. This is not an official probation determination.
     *
     * @author Astrid Noizillier
     */
    public String getAcademicStanding() {
        if (getCompletedCoursesCount() == 0) {
            return "Not Yet Evaluated";
        }

        if (calculateGPA() >= 3.0) {
            return "Good Standing";
        }

        return "Below GPA Requirement";
    }
}
