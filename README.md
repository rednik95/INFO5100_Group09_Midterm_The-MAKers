# Digital University System

## Project Overview
This project implements a digital twin of a university ecosystem, utilizing role-based access control to manage the interactions between Administrators, Faculty, and Students. The objective is to demonstrate a secure, compartmentalized architecture using Java Swing.

**Key Features Implemented:**
*   Role-based authentication and authorization.
*   Centralized University Model managing course catalogs and schedules.
*   Administrator account and personnel management.
*   Faculty course offering and profile management.
*   Student registration, transcripts, and graduation auditing.
*   Interactive, CardLayout-based Java Swing UI.

---

## Team Information
| Name | Role / Use Case | NUID |
| :--- | :--- | :--- |
| **Kinder Izzo Celemin** | Administrator Use Case | 003947783 |
| **Astrid Noizillier** | Faculty Use Case | [Insert NUID] |
| **Mayu Rocha Yamada** | Student Use Case | [Insert NUID] |

---

## Installation & Setup Instructions

### Prerequisites
*   **Java:** JDK [Insert Version, e.g., 19] or higher.
*   **IDE:** Apache NetBeans 16 (recommended for Swing UI compilation).
*   **Version Control:** Git.

### Setup Steps
1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/rednik95/INFO5100_Group09_Midterm_The-MAKers.git
    cd INFO5100_Group09_Midterm_The-MAKers
    ```
2.  **Open in IDE:** Open the project folder in Apache NetBeans.
4.  **Run the Application:** Navigate to `src/Business/ProfileWorkAreaMainFrame.java`, right-click the file, and select **Run File**.

---

## Authentication & Access Control

### The Authentication Process
The application features a secure login screen where users input their assigned credentials. The system cross-references the credentials with the `UserAccountDirectory`. Upon successful authentication, the user is routed to their specific `WorkArea` based on their assigned role, and the system records the `lastAccessTime`.

### Authorization Rules
*   **Administrators:** Granted access to `AdminRoleWorkAreaJPanel`. Authorized to create, modify, and delete all user accounts and personnel profiles (Faculty/Student/Staff) across the system.
*   **Faculty:** Granted access to `FacultyWorkAreaJPanel`. Authorized to view and update specific course offerings, generate student performance reports, and manage their own pilot profiles.
*   **Students:** Granted access to `StudentWorkAreaJPanel`. Authorized to register for classes (via empty seat assignments), review their academic transcripts, and perform graduation audits.

---

## Features Implemented & Contribution Breakdown

### Administrator Use Case 1 (Implemented by Kinder Izzo Celemin)
*   **Administer User Accounts:** Full CRUD capabilities for user logins via `ManageUserAccountsJPanel` and `AdminUserAccount`.
*   **Register Persons (HR):** Ability to add new identities to the system via `ManagePersonsJPanel` and `AdministerPersonJPanel`.
*   **Manage Student/Faculty Records:** Capability to update, delete, or view academic and staff data.
*   **Manage Own Profile:** Admin profile updates via `AdminMyProfileJPanel`.

### Faculty Use Case 2 (Implemented by Astrid Noizillier)
*   **Manage Courses:** View and update specific class details within the `CourseSchedule`.
*   **Manage Own Profile:** Update personal faculty details.
*   **Performance Reports:** Generate reports based on student grades within assigned classes.
*   **View Student Profiles:** Review academic progress and interests of enrolled students.

### Student Use Case 3 (Implemented by Mayu Rocha Yamada)
*   **Manage Coursework:** Track progress and submit assignments.
*   **Class Registration:** Enroll in or drop courses by claiming a `SeatAssignment` in a `CourseOffer`.
*   **Graduation Audit:** Track core and elective credits against `Degree` requirements.
*   **Review Transcript:** View academic history compiled from previous `CourseLoad`s.

---

## Usage Instructions

1.  **Launch the App:** Run `ProfileWorkAreaMainFrame.java`.
2.  **Login:**
    *   *Admin Example:* Username: `admin` | Password: `[Insert Password]`
    *   *Faculty Example:* Username: `faculty` | Password: `[Insert Password]`
3.  **Navigate:** Use the left-hand control panel buttons to access your role's specific features. The right-hand work area will update using CardLayout.
4.  **Data Entry:** When creating a new entity (like a Person or User Account), ensure all fields are filled out, as the system strictly validates against empty or NULL values.
5.  **Logout:** Click the Logout button to return to the main authentication screen.

---

## Testing Guide

### System Verification
1.  **Run Main:** Launch the application. The `ConfigureABusiness.java` file will automatically bootstrap the University Model with sample departments, courses, and a pre-registered faculty member.
2.  **Authentication Test:** Attempt to log in with an invalid username or password. A dialog box should appear denying access.
3.  **Authorization Test:** Log in as a Student. Verify that you cannot access the Administrator HR panels or the Faculty course management tools.
4.  **Validation Test:** Attempt to save a new User Account with a blank username or password. Verify that the system throws an error dialog and prevents the save.

---

## Challenges & Solutions

*   **Challenge #1:** Organizing the folder structure to prevent messy import statements across different packages.
*   **Solution #1:** We ran a mass refactoring script to clean the package structure, consolidating the backend into a clean `University.*` package format not the `info5100.university.example.<class>.<package>.` Right-click the project and select **Clean and Build**. Ensure all `import University.*;` statements resolve correctly.

---

## Future Enhancements
*   **Database Integration:** Transition from volatile memory (ArrayLists) to a persistent database.
*   **Advanced Analytics:** Implement charting libraries to visualize university revenue and student performance trends over time.
*   **Enhanced Employer Portal:** Build out the `EmployerProfile` UI to allow companies to directly recruit students based on their transcripts and high-impact courses.

---

## Contribution Breakdown:
| Name |Contribution |
| :--- | :--- |
| **Astrid Noizillier** | Adv Programmer|
| **Kinder Izzo Celemin** | Coordinator | 
| **Mayu Rocha Yamada** | Programmer |

