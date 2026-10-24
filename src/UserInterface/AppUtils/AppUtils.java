/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.AppUtils;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Astrid Noizillier
 */
final public class AppUtils {

    private AppUtils() {
    }

    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_INACTIVE = "Inactive";

    public static final String ROLE_STUDENT = "Student";
    public static final String ROLE_FACULTY = "Faculty";
    public static final String ROLE_ADMIN = "Admin";

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.MEDIUM,
                Locale.getDefault()
        ).format(date);
    }

    public static String getDatePattern() {
        DateFormat df = DateFormat.getDateInstance(
                DateFormat.SHORT,
                Locale.getDefault()
        );

        return ((SimpleDateFormat) df).toPattern();
    }

    public static int confirmChange(Component window) {
        int choice = JOptionPane.showConfirmDialog(
                window,
                "Do you want to save changes?",
                "Confirmation",
                JOptionPane.OK_CANCEL_OPTION
        );
        return choice;
    }

    public static int cancelChange(Component window) {
        int choice = JOptionPane.showConfirmDialog(
                window,
                "Leave without saving changes?",
                "Unsaved Changes",
                JOptionPane.OK_CANCEL_OPTION
        );
        return choice;
    }

    public static void missingFields(Component window, String fieldName) {
        JOptionPane.showMessageDialog(
                window,
                "Please fill in the required field: " + fieldName,
                "Missing Information",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void saveSuccess(Component window, String entity, String id) {
        JOptionPane.showMessageDialog(
                window,
                entity + " saved successfully. ID: " + id,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void passwordMismatch(Component window) {
        JOptionPane.showMessageDialog(
                window,
                "Passwords do not match.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static boolean confirmDelete(java.awt.Component parent) {
        return javax.swing.JOptionPane.showConfirmDialog(
                parent,
                "Are you sure you want to delete the selected item?",
                "Confirm Deletion",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
        ) == javax.swing.JOptionPane.YES_OPTION;
    }

    public static void deleteSuccess(Component parent) {
        JOptionPane.showMessageDialog(
                parent,
                "Deleted successfully.",
                "Deletion successful",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
