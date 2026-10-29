package UserInterface.AppUtils;

import Business.Profiles.StudentProfile;
import University.CourseCatalog.Course;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.Department.Department;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kinder Izzo Celemin
 */
public class StudentAcademicModel {
    
    // Static collections managing department data and student records across panels
    private static Department universityDepartment;
    private static final ArrayList<OfferingEntry> catalogOfferings = new ArrayList<>();
    private static final ArrayList<StudentRecordHolder> studentRecordList = new ArrayList<>();
    
    /**
     * Represents a single course record for a student, tracking their
     * enrollment, grade, assignment submissions, and completion progress.
     */
    public static class StudentCourseRecord {

        private String courseNumber;
        private String courseName;
        private double credits;
        private String semester;
        private String requirementType; // "Core" or "Elective"
        private String instructor;
        private String grade;           // "A", "A-", "B+", "In Progress", etc.
        private String assignmentText;
        private double progressPercent;

        /**
         * Constructs a new StudentCourseRecord with all academic attributes.
         */
        public StudentCourseRecord(
                String courseNumber, 
                String courseName, 
                double credits,
                String semester, 
                String requirementType, 
                String instructor,
                String grade, 
                String assignmentText, 
                double progressPercent) {
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            this.credits = credits;
            this.semester = semester;
            this.requirementType = requirementType;
            this.instructor = instructor;
            this.grade = grade;
            this.assignmentText = assignmentText;
            this.progressPercent = progressPercent;
        }

        public String getCourseNumber() {
            return courseNumber;
        }

        public void setCourseNumber(String courseNumber) {
            this.courseNumber = courseNumber;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public double getCredits() {
            return credits;
        }

        public void setCredits( double   credits) {
            this.credits = credits;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public String getRequirementType() {
            return requirementType;
        }

        public void setRequirementType(String requirementType) {
            this.requirementType = requirementType;
        }

        public String getInstructor() {
            return instructor;
        }

        public void setInstructor(String instructor) {
            this.instructor = instructor;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getAssignmentText() {
            return assignmentText;
        }

        public void setAssignmentText(String assignmentText) {
            this.assignmentText = assignmentText;
        }

        public double getProgressPercent() {
            return progressPercent;
        }

        public void setProgressPercent( double   progressPercent) {
            this.progressPercent = progressPercent;
        }
        
        /**
         * Converts a letter grade into its corresponding grade point value for GPA calculations.
         * @return numerical grade points, or -1.0 if the course is "In Progress".
         */
        public double getGradePoints() {
            if (grade == null) {
                return -1.0;
            }
            switch (grade) {
                case "A":
                    return 4.0;
                case "A-":
                    return 3.7;
                case "B+":
                    return 3.3;
                case "B":
                    return 3.0;
                case "B-":
                    return 2.7;
                case "C+":
                    return 2.3;
                case "C":
                    return 2.0;
                default:
                    return -1.0; // "In Progress"
            }
        }
    }
    
    /**
     * Represents an open course offering available in the university schedule for registration.
     */
    public static class OfferingEntry {

        private String courseNumber;
        private String courseName;
        private double credits;
        private String semester;
        private String requirementType;
        private String instructor;
        private double seatsAvailable;

        /**
         * Constructs an OfferingEntry with scheduling and capacity details.
         */
        public OfferingEntry(String courseNumber, String courseName, double credits,
                String semester, String requirementType, String instructor, double seatsAvailable) {
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            this.credits = credits;
            this.semester = semester;
            this.requirementType = requirementType;
            this.instructor = instructor;
            this.seatsAvailable = seatsAvailable;
        }

        public String getCourseNumber() {
            return courseNumber;
        }

        public String getCourseName() {
            return courseName;
        }

        public double getCredits() {
            return credits;
        }

        public String getSemester() {
            return semester;
        }

        public String getRequirementType() {
            return requirementType;
        }

        public String getInstructor() {
            return instructor;
        }

        public double getSeatsAvailable() {
            return seatsAvailable;
        }

        public void setSeatsAvailable( double   seatsAvailable) {
            this.seatsAvailable = seatsAvailable;
        }
    }
    
    /**
     * Internal helper class to link a student's unique NUID to their specific list of course records.
     */
    private static class StudentRecordHolder {

        private String nuid;
        private ArrayList<StudentCourseRecord> records;

        public StudentRecordHolder(String nuid) {
            this.nuid = nuid;
            this.records = new ArrayList<>();
        }
    }
    
    /**
     * Retrieves all available course offerings across semesters.
     * @return 
     */
    public static ArrayList<OfferingEntry> getCatalogOfferings() {
        return catalogOfferings;
    }

    /**
     * Fetches or initializes the ArrayList of course records for a specific student profile.Searches the studentRecordList by NUID.
     * @param sp
     * @return 
     */
    public static ArrayList<StudentCourseRecord> getRecordsForStudent(StudentProfile sp) {
        String nuid = (sp != null && sp.getNuid() != null) ? sp.getNuid() : "DEFAULT_STUDENT";

        // Search the ArrayList for an existing student record holder
        for (StudentRecordHolder holder : studentRecordList) {
            if (holder.nuid.equalsIgnoreCase(nuid)) {
                return holder.records;
            }
        }

        // If not found, create a new holder, pre-populate sample courses, and add to ArrayList
        StudentRecordHolder newHolder = new StudentRecordHolder(nuid);
        newHolder.records.add(new StudentCourseRecord("INFO 5001", "Data Modeling & Engineering", 4, "Fall 2025", "Core", "Dr. Kal Bugrara", "A", "Final Architecture Model Submitted", 100));
        newHolder.records.add(new StudentCourseRecord("INFO 6105", "Data Science Eng Methods", 4, "Spring 2026", "Elective", "Dr. S. Patel", "A-", "ML Capstone Notebook Submitted", 100));
        newHolder.records.add(new StudentCourseRecord("INFO 5100", "Application Engineering & Dev", 4, "Fall 2026", "Core", "Dr. Kal Bugrara", "In Progress", "Midterm Project In Progress", 50));

        studentRecordList.add(newHolder);
        return newHolder.records;
    }
    
    /**
     * Calculates total completed (graded) credits for a student.
     * @param sp
     * @return 
     */
    public static double getCompletedCredits(StudentProfile sp) {
       double sum = 0;
        for (StudentCourseRecord r : getRecordsForStudent(sp)) {
            if (!"In Progress".equalsIgnoreCase(r.getGrade())) {
                sum += r.getCredits();
            }
        }
        return sum;
    }
    
    /**
     * Calculates total in-progress credits for active enrollments.
     * @param sp
     * @return 
     */
    public static double getInProgressCredits(StudentProfile sp) {
        double  sum = 0;
        for (StudentCourseRecord r : getRecordsForStudent(sp)) {
            if ("In Progress".equalsIgnoreCase(r.getGrade())) {
                sum += r.getCredits();
            }
        }
        return sum;
    }

    /**
     * Calculates total completed core course credits for graduation audits.
     * @param sp
     * @return 
     */
    public static double getCompletedCoreCredits(StudentProfile sp) {
        double  sum = 0;
        for (StudentCourseRecord r : getRecordsForStudent(sp)) {
            if (!"In Progress".equalsIgnoreCase(r.getGrade()) && "Core".equalsIgnoreCase(r.getRequirementType())) {
                sum += r.getCredits();
            }
        }
        return sum;
    }

    /**
     * Computes the cumulative Grade Point Average (GPA) based on completed courses.
     * @param sp
     * @return 
     */
    public static double calculateCumulativeGPA(StudentProfile sp) {
        double qualityPoints = 0.0;
        double  gradedCredits = 0;
        for (StudentCourseRecord r : getRecordsForStudent(sp)) {
            double gp = r.getGradePoints();
            if (gp >= 0.0) {
                qualityPoints += (gp * r.getCredits());
                gradedCredits += r.getCredits();
            }
        }
        return gradedCredits == 0 ? 0.0 : (qualityPoints / gradedCredits);
    }
    
    
    /**
     * Sample Data
     */
    static {
        // Initialize the underlying university.Department model & CourseCatalog
        universityDepartment = new Department("Information Systems");

        Course c1 = universityDepartment.newCourse("Application Engineering & Dev", "INFO 5100", 4);
        Course c2 = universityDepartment.newCourse("Data Modeling & Engineering", "INFO 5001", 4);
        Course c3 = universityDepartment.newCourse("Program Structure & Algorithms", "INFO 6205", 4);
        Course c4 = universityDepartment.newCourse("Web Design & User Experience", "INFO 6150", 4);
        Course c5 = universityDepartment.newCourse("Data Science Eng Methods", "INFO 6105", 4);
        Course c6 = universityDepartment.newCourse("Database Management & Design", "DAMG 6210", 4);
        Course c7 = universityDepartment.newCourse("Object-Oriented Design", "CSYE 6200", 4);
        Course c8 = universityDepartment.newCourse("Agile Software Development", "INFO 7245", 4);

        universityDepartment.addCoreCourse(c1);
        universityDepartment.addCoreCourse(c2);
        universityDepartment.addCoreCourse(c3);
        universityDepartment.addElectiveCourse(c4);
        universityDepartment.addElectiveCourse(c5);
        universityDepartment.addElectiveCourse(c6);
        universityDepartment.addElectiveCourse(c7);
        universityDepartment.addElectiveCourse(c8);

        CourseSchedule fall2026 = universityDepartment.newCourseSchedule("Fall 2026");
        CourseOffer co1 = fall2026.newCourseOffer("INFO 5100");
        if (co1 != null) {
            co1.generatSeats(25);
        }

        // Populate schedule offerings for the Registration UI
        catalogOfferings.add(new OfferingEntry("INFO 5100", "Application Engineering & Dev", 4, "Fall 2026", "Core", "Dr. Kal Bugrara", 24));
        catalogOfferings.add(new OfferingEntry("INFO 6205", "Program Structure & Algorithms", 4, "Fall 2026", "Core", "Dr. M. Robin", 20));
        catalogOfferings.add(new OfferingEntry("INFO 6150", "Web Design & User Experience", 4, "Fall 2026", "Elective", "Prof. R. Smith", 18));
        catalogOfferings.add(new OfferingEntry("DAMG 6210", "Database Management & Design", 4, "Fall 2026", "Elective", "Prof. A. Chen", 15));
        catalogOfferings.add(new OfferingEntry("CSYE 6200", "Object-Oriented Design", 4, "Spring 2027", "Elective", "Dr. D. Peters", 30));
        catalogOfferings.add(new OfferingEntry("INFO 7245", "Agile Software Development", 4, "Spring 2027", "Elective", "Prof. K. Davis", 22));
    }
    
}
