<div align="center">

# 🎓 Digital University System
### INFO 5100 — Application Engineering & Development (Midterm Project)
**Team 09: The MAKers**

[![Java](https://img.shields.io/badge/Java-JDK%2019%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![IDE](https://img.shields.io/badge/IDE-Apache%20NetBeans%2016%2B-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white)](https://netbeans.apache.org/)
[![UI](https://img.shields.io/badge/UI-Java%20Swing%20CardLayout-009999?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)]()

*A role-based Digital University platform integrating the Reference University Architecture with an Access Control Layer for University Administrators, Faculty Members, and Students.*

[Project Overview](#-project-overview) •
[Team Information](#-team-information) •
[Installation & Setup](#-installation--setup-instructions) •
[Access Control](#-authentication--access-control) •
[Features](#-features-implemented) •
[Usage & Testing](#-usage-instructions)

</div>

---

## 📖 Project Overview

The **Digital University System** is a multi-role Java Swing desktop application built for the INFO 5100 Midterm Project at Northeastern University. The objective of this project is to integrate a reference implementation of the **Digital University Model** (`University.*`) with a robust **Access Control Layer** (`Business.*` and `UserInterface.*`) that enforces authentication, role-based authorization, and complete CRUD workflows across three core university personas:

1. **University Administrator (Use Case 1)**
2. **Faculty Member (Use Case 2)**
3. **Student (Use Case 3)**

### ✨ Key Features Implemented
* **Role-Based Access Control (RBAC):** Centralized authentication routing users strictly to their authorized work areas (`AdminRoleWorkAreaJPanel`, `FacultyWorkAreaJPanel`, `StudentWorkAreaJPanel`).
* **Pre-Registration & Student Activation Flow:** Administrators pre-register students with an **NUID** and **Activation Code**; students subsequently claim and activate their accounts via `StudentSignUpJPanel`.
* **Comprehensive Admin CRUD & Audit Timestamps:** Full creation, searching, modification, and deletion of User Accounts, Faculty, Students, and HR Personnel with automatic `Last Activity` and `Last Updated` timestamp tracking.
* **Dynamic Faculty Course & Performance Management:** Faculty members manage course details, inspect enrolled student profiles (hobbies, interests, progress), and generate class performance/grade reports.
* **End-to-End Student Academic Portal:** Students register/drop course offerings, submit coursework and track completion percentages, run degree graduation audits, and review semester transcripts with live cumulative GPA calculations.
* **Clean `CardLayout` Navigation & Input Validation:** All workflows operate smoothly inside `CardSequencePanel` with centralized validation and confirmation dialogs powered by `AppUtils`.

---

## 👥 Team Information

**Group 09 — The MAKers**

| Team Member | Assigned Use Case & Role | NUID | GitHub Branch | Primary Package / Scope |
| :--- | :--- | :--- | :--- | :--- |
| **Kinder Izzo Celemin** | **Use Case 1:** Administrator Use Case *(University Admin)* | `003947783` | `feature-admin` | `UserInterface.WorkAreas.AdminRole.*`<br>`UserInterface.AppUtils.StudentAcademicModel` |
| **Astrid Noizillier** | **Use Case 2:** Faculty Use Case *(Faculty Member)* | *(Insert Astrid's NUID)* | `feature-faculty` | `UserInterface.WorkAreas.FacultyRole.*`<br>`UserInterface.AppUtils.AppUtils` |
| **Mayu Rocha Yamada** | **Use Case 3:** Student Use Case *(Student)* | *(Insert Mayu's NUID)* | `feature-student` | `UserInterface.WorkAreas.StudentRole.*`<br>`Business.Profiles.StudentProfile` |

> 💡 *Note: Remember to replace the placeholder NUIDs above with Astrid's and Mayu's NUIDs before final submission.*

---

## ⚙️ Installation & Setup Instructions

### Prerequisites
* **Java Development Kit (JDK):** Version **19** or higher (compatible with JDK 17+).
* **IDE:** **Apache NetBeans 16** or newer (required for Ant build scripts and `.form` GUI designer files).
* **Version Control:** **Git** (Git Bash, Terminal, or Lazygit).
* **Included Libraries:** `AbsoluteLayout`, `darcula-1.0.0.jar`, `objectdb.jar`, and `velocity-engine-core-2.3.jar` (all pre-bundled inside the `/lib` folder).

### Step-by-Step Setup
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/rednik95/INFO5100_Group09_Midterm_The-MAKers.git
   cd INFO5100_Group09_Midterm_The-MAKers
   ```
2. **Open the Project in Apache NetBeans:**
   * Launch **Apache NetBeans**.
   * Navigate to **File > Open Project...** and select the cloned `INFO5100_Group09_Midterm_The-MAKers` directory.
3. **Clean and Build the Project:**
   * Right-click the project node in the **Projects** pane and select **Clean and Build** (or press `Shift + F11`).
   * Verify that the output console reports `BUILD SUCCESSFUL` with zero compilation errors.
4. **Run the Application:**
   * Expand `Source Packages > Business`.
   * Right-click **`ProfileWorkAreaMainFrame.java`** and select **Run File** (`Shift + F6`), or click the green **Run Project** (`F6`) button in the toolbar.

---

## 🔐 Authentication & Access Control

### 1. The Authentication Process
* **Login Verification:** Users enter their username and password on the left-hand login sidebar of `ProfileWorkAreaMainFrame`. The system queries `UserAccountDirectory.AuthenticateUser(username, password)`.
* **Account Status Enforcement:** Only accounts with an `"Active"` status are permitted to log in. Accounts marked `"Inactive"` are blocked from accessing work areas.
* **Activity Tracking:** Upon successful authentication, the system updates the account's `lastActivity` timestamp (`new Date()`) and loads the appropriate role work area into `CardSequencePanel`.
* **Student NUID Activation (`StudentSignUpJPanel`):** Students pre-registered by an Admin in HR (`ManagePersonsJPanel`) initially do not have an active login. They click **Sign Up** on the main frame, enter their assigned **NUID** and **Activation Code**, and set their personal password to activate their `UserAccount`.

### 2. Role-Based Authorization Rules
| Role | Authorized Work Area | Access Permissions & Restrictions |
| :--- | :--- | :--- |
| **Admin** | `AdminRoleWorkAreaJPanel` | Full access to User Account CRUD, HR Person Registration, Student Record Management, Faculty Record Management, and Admin Self-Profile. Prevented from deleting or deactivating their own logged-in Admin account. |
| **Faculty** | `FacultyWorkAreaJPanel` | Authorized to manage assigned courses, view enrolled student profiles, generate class grade reports, and edit their own faculty profile. Restricted from Admin HR/Account panels and Student registration panels. |
| **Student** | `StudentWorkAreaJPanel` | Authorized to enroll/drop courses, submit coursework, run graduation audits, view transcripts, and edit their own student profile. Restricted from Admin and Faculty management panels. |

---

## 🛠️ Features Implemented

### 1. Use Case 1: Administrator Use Case *(Implemented by Kinder Izzo Celemin)*
* **Administer User Accounts (`ManageUserAccountsJPanel.java`, `AdminUserAccount.java`):**
  * View all system accounts in a searchable table displaying `User Name`, `Status`, `Last Activity`, and `Last Updated`.
  * Search accounts dynamically by Person ID, First Name, or Last Name.
  * View and edit account credentials, status (`Active`/`Inactive`), role-specific attributes (`Job Title`, `Subject`, `Major`, `Department`, `Hire Date`), and reset passwords.
  * Automatic form clearing (`clearFields()`) whenever an account is created, edited, or exited so stale data never persists across screens.
  * Self-deletion safeguard preventing the logged-in administrator from deleting their own account.
* **Register Persons — HR (`ManagePersonsJPanel.java`):**
  * Dynamic role-based registration form supporting **Admin (Academic Staff)**, **Faculty**, and **Student** creation.
  * Automatically adapts form labels and visibility based on selected role (e.g., switching `Username` to `NUID`, `Job Title` to `Major` or `Subject`, and `Password` to `Activation Code` for Students).
* **Manage Student Records (`ManageStudentsJPanel.java`, `AdminStudentProfile.java`):**
  * Search, view, create, update, and cascadingly delete student records (`StudentProfile`, `Person`, and linked `UserAccount`).
* **Manage Faculty Records (`ManageFacultyJPanel.java`, `AdminUserAccount.java`):**
  * Search, view, create, update, and delete faculty profiles (`Department`, `Subject`, `Hire Date`, contact details).
* **Manage Own Profile (`AdminUserAccount.java` with `myProfile = true`):**
  * Allows the logged-in University Admin to view and update their personal contact info, department, job title, username, and password while locking the status dropdown so they cannot accidentally deactivate themselves.

### 2. Use Case 2: Faculty Use Case *(Implemented by Astrid Noizillier)*
* **Manage Courses (`FacultyWorkAreaJPanel.java`):**
  * View and update course details, syllabi, and scheduling information within the department's `CourseSchedule`.
* **Manage Own Profile (`FacultyMyProfileJPanel.java`):**
  * View and update personal faculty profile attributes (name, email, phone, department, subject).
* **Generate Performance Reports:**
  * Compile and review student grade distributions and academic performance across assigned classes.
* **Manage Student Profiles:**
  * Inspect enrolled student profiles, including academic progress, hobbies, and interests.
* **Shared UI Validation Utilities (`AppUtils.java`):**
  * Standardized confirmation dialogs (`confirmChange`, `cancelChange`, `confirmDelete`), validation alerts (`missingFields`, `passwordMismatch`), and locale-aware date formatting (`formatDate`, `getDatePattern`).

### 3. Use Case 3: Student Use Case *(Implemented by Mayu Rocha Yamada)*
* **Manage Coursework (`StudentAcademicModel.java` & Student Coursework UI):**
  * Track active course enrollments, update assignment submission text, and record completion progress percentages (`0%`–`100%`).
* **Register for Classes:**
  * Browse open course offerings (`OfferingEntry`) by semester, enroll in available seats, and drop in-progress courses with real-time seat count updates.
* **Perform Graduation Audit:**
  * Track completed credits, in-progress credits, and core vs. elective requirements against the **32-credit** MS Information Systems degree requirement.
* **Review Transcript (`ReviewTranscriptJPanel.java`):**
  * View official course history by semester, letter grades, credit hours, academic standing, and live weighted **Cumulative GPA** calculation on a 4.0 scale.
* **Manage Own Profile & Sign-Up (`StudentMyProfileJPanel.java`, `StudentSignUpJPanel.java`):**
  * Activate pre-registered student accounts using NUID + Activation Code and update personal contact details, hobbies, and interests.

---

## 🖥️ Usage Instructions

### Default Login Credentials
When the application starts, `ConfigureABusiness.initialize()` pre-populates sample accounts for immediate testing:

| Role | Username | Password | Notes |
| :--- | :--- | :--- | :--- |
| **University Admin** | `admin` | `****` | Full access to all 5 Administrator responsibilities |
| **Faculty Member** | `faculty` | `****` | Access to Faculty course, student, and profile tools |
| **Student (Active)** | `adam` | `****` | Pre-activated student account for immediate login |

### Step-by-Step Walkthrough Scenarios

#### Scenario A: Administrator Pre-Registers a Student & Student Activates Account
1. Log in as **Admin** (`admin` / `****`).
2. Click **Register Persons (HR)** (`ManagePersonsJPanel`).
3. Select **Role: `Student`** from the dropdown. Notice the form dynamically switches to **NUID**, **Major**, and **Activation Code**.
4. Enter First Name, Last Name, NUID (e.g., `003999888`), Major (`Information Systems`), and Activation Code (e.g., `1234`), then click **Save**.
5. Click **Sign Up** on the left sidebar (`StudentSignUpJPanel`), enter NUID `003999888` and Activation Code `1234`, set a new password, and log in as the newly activated student!

#### Scenario B: Administrator Manages User Accounts & Faculty Records
1. Log in as **Admin** (`admin` / `****`).
2. Click **Administer User Accounts** (`ManageUserAccountsJPanel`).
3. Use the **Search** bar to filter by name or Person ID, select an account, and click **More Details**.
4. Click **Edit** in `AdminUserAccount`, update the user's department, phone number, or password, and click **Save**.
5. Click **My Profile** on the Admin dashboard to update the Administrator's own profile details.

#### Scenario C: Student Enrolls in Classes & Reviews Transcript
1. Log in as a **Student** (`adam` / `****` or your newly activated student account).
2. Open **Register for Classes** to enroll in an open `Fall 2026` or `Spring 2027` course offering.
3. Open **Manage Coursework** to submit an assignment and update course progress to `100%`.
4. Open **Review Transcript** and **Graduation Audit** to verify completed credits and cumulative GPA.

---

## 🧪 Testing Guide

| Test Case ID | Feature Under Test | Test Steps | Expected Result |
| :--- | :--- | :--- | :--- |
| **TC-01** | **Authentication & Invalid Login** | Enter an invalid username/password and click `Login`. | Error dialog appears; user is denied access to `CardSequencePanel`. |
| **TC-02** | **Role Authorization Isolation** | Log in as `adam` (Student) or `faculty` (Faculty). | User is routed strictly to `StudentWorkAreaJPanel` or `FacultyWorkAreaJPanel`; Admin panels are inaccessible. |
| **TC-03** | **Required Field Validation** | In `ManagePersonsJPanel` or `AdminUserAccount`, leave required fields blank and click `Save`. | `AppUtils.missingFields()` warning dialog pops up and prevents saving incomplete data. |
| **TC-04** | **Password Mismatch Validation** | Enter different values in `Password` and `Confirm Password` and click `Save`. | `AppUtils.passwordMismatch()` warning dialog pops up and blocks the save. |
| **TC-05** | **Duplicate Username Prevention** | Attempt to create or rename an account to an existing username (`admin`). | Warning dialog `"This username already exists."` prevents duplicate creation. |
| **TC-06** | **Admin Self-Deletion Protection** | Log in as `admin`, select `admin` in `ManageUserAccountsJPanel`, and click `Delete`. | Warning dialog `"You cannot delete your own account."` blocks self-deletion. |
| **TC-07** | **Clean Form State on Re-entry** | Create or edit an account in `AdminUserAccount` or `ManagePersonsJPanel`, save/exit, and re-open the panel. | `clearFields()` resets all text boxes so no stale text remains from previous sessions. |

---

## 🧩 Challenges & Solutions

1. **Challenge: Bridging the University Model (`University.*`) with the Access Control Layer (`Business.*`)**
   * **Problem:** The starter code came from two separate packages (`Info5100-University-Example` and `ProfileWorkareaExample`) with different `Person` and `StudentProfile` classes.
   * **Solution:** We standardized the package structure under `University.*` and built `StudentAcademicModel.java` in `UserInterface.AppUtils` to seamlessly connect `Business.Profiles.StudentProfile` (by NUID) to `University.Department`, `CourseCatalog`, `CourseSchedule`, and `CourseOffer`.
2. **Challenge: Stale Form Data Persisting in `CardLayout` Panels**
   * **Problem:** Navigating back and forth between `ManageUserAccountsJPanel`, `AdminUserAccount`, and `ManagePersonsJPanel` occasionally left previous input values in the text boxes.
   * **Solution:** We implemented dedicated `clearFields()` methods, attached a `ComponentAdapter` (`componentShown`), and removed completed form cards from `CardSequencePanel` upon returning so every form loads in a clean state.
3. **Challenge: Role-Specific Registration Requirements**
   * **Problem:** Registering a Student requires an NUID, Major, and Activation Code, whereas registering Faculty or Admin staff requires a Username, Password, Department, Job Title/Subject, and Hire Date.
   * **Solution:** We implemented a dynamic listener (`roleComboActionPerformed`) in `ManagePersonsJPanel.java` that automatically re-labels fields and toggles visibility of `Hire Date` and `Department` based on the selected role, paired with role-aware validation.

---

## 🚀 Future Enhancements

* **Persistent Database Storage:** Migrate in-memory `ArrayList` directories (`PersonDirectory`, `UserAccountDirectory`, `StudentDirectory`, `FacultyDirectory`) to a relational database (PostgreSQL/MySQL) or ObjectDB persistence.
* **Password Hashing & Security:** Integrate BCrypt password hashing instead of plaintext password comparisons in `UserAccount`.
* **Visual Analytics Dashboard:** Add JavaFX/JFreeChart visualizations for university-wide tuition revenue, course enrollment capacity, and GPA distributions.
* **Automated Email Notifications:** Send automated welcome emails containing activation codes when an Administrator pre-registers a new student in HR.

---

## 📊 Contribution Breakdown

| Team Member | Coding & Architecture Contributions | Documentation, Testing & Presentation |
| :--- | :--- | :--- |
| **Kinder Izzo Celemin** | • Implemented **Use Case 1 (Administrator)** (`ManageUserAccountsJPanel`, `AdminUserAccount`, `ManagePersonsJPanel`, `ManageFacultyJPanel`, `ManageStudentsJPanel`, `AdminStudentProfile`).<br>• Built `StudentAcademicModel` bridging the `University.*` package.<br>• Configured repository structure, package refactoring (`University.*`), and form state reset logic. | • Authored `README.md` documentation and architecture diagrams.<br>• Performed end-to-end validation and CRUD testing for Admin workflows.<br>• Co-prepared presentation slides and live demo recording. |
| **Astrid Noizillier** | • Implemented **Use Case 2 (Faculty)** (`FacultyWorkAreaJPanel`, `FacultyMyProfileJPanel`, course management, and student performance reporting).<br>• Created `AppUtils.java` providing centralized validation alerts, confirmation dialogs, and date formatting helpers. | • Conducted unit and UI testing on Faculty workflows and `AppUtils` validations.<br>• Contributed to presentation slides and Faculty live demo segment. |
| **Mayu Rocha Yamada** | • Implemented **Use Case 3 (Student)** (`StudentWorkAreaJPanel`, `ReviewTranscriptJPanel`, `StudentMyProfileJPanel`, `StudentSignUpJPanel`, coursework tracking, registration, and graduation audit).<br>• Integrated NUID activation code sign-up workflow. | • Tested Student sign-up, enrollment, GPA calculations, and transcript rendering.<br>• Contributed to presentation slides and Student live demo segment. |

---

<div align="center">
  <sub>Built with ❤️ by <b>Team 09 (The MAKers)</b> — Northeastern University INFO 5100 (Fall 2026)</sub>
</div>
