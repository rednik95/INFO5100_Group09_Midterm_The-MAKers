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
 * @Desc: Utility class providing status/role constants, date formatting, and 
 * validation/confirmation dialogs.
 * @author Astrid Noizillier
 */
final public class AppUtils {

    private AppUtils() {
    }

    //Used for stating status in a combo box
    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_INACTIVE = "Inactive";

    //used for stating role in a combo box
    public static final String ROLE_STUDENT = "Student";
    public static final String ROLE_FACULTY = "Faculty";
    public static final String ROLE_ADMIN = "Admin";
    
    /**
     * @Desc: Formats a Date object into a localized short-date + medium-time string.
     */
    public static String formatDate(Date date) {
        
        // If date is null
        if (date == null) { 
            return "";
        }
        
        // Format date and time using default locale
        return DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.MEDIUM,
                Locale.getDefault()
        ).format(date);
    }

    /**
     * @Desc: Produces a short date format pattern string for JSpinner date
     * editors.
     */
    public static String getDatePattern() {
        DateFormat df = DateFormat.getDateInstance(
                DateFormat.SHORT,
                Locale.getDefault()
        );

        return ((SimpleDateFormat) df).toPattern();
    }

    /**
     * @Desc: Displays a confirmation dialog asking if the user wants to save
     * changes.
     */
    public static int confirmChange(Component window) {
        
        // Show OK/Cancel confirmation dialog
        int choice = JOptionPane.showConfirmDialog( 
                window,
                "Do you want to save changes?",
                "Confirmation",
                JOptionPane.OK_CANCEL_OPTION
        );
        return choice;
    }
    
    /**
     * @Desc: Displays a confirmation dialog asking if the user wants to leave
     * without saving changes.
     */
    public static int cancelChange(Component window) {
        int choice = JOptionPane.showConfirmDialog( // Show OK/Cancel confirmation dialog
                window,
                "Leave without saving changes?",
                "Unsaved Changes",
                JOptionPane.OK_CANCEL_OPTION
        );
        return choice;
    }
    
    /**
     * @Desc: Displays a warning message dialog indicating which required field
     * is missing.
     */
    public static void missingFields(Component window, String fieldName) {
        JOptionPane.showMessageDialog(  // Show warning dialog
                window,
                "Please fill in the required field: " + fieldName,
                "Missing Information",
                JOptionPane.WARNING_MESSAGE
        );
    }
    
    /**
     * @Desc: Displays an information message confirming that an entity was
     * saved successfully.
     */
    public static void saveSuccess(Component window, String entity, String id) {
        JOptionPane.showMessageDialog(  // Show information dialog with entity name and ID
                window,
                entity + " saved successfully. ID: " + id,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * @Desc: Displays a warning message when the password and confirmation
     * password do not match.
     */
    public static void passwordMismatch(Component window) {
        JOptionPane.showMessageDialog(
                window,
                "Passwords do not match.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE
        );
    }
    
    /**
     * @Desc: Displays a Yes/No warning dialog to confirm deletion of a selected
     * item.
     */
    public static boolean confirmDelete(java.awt.Component parent) {
        return javax.swing.JOptionPane.showConfirmDialog(   // Return true only if user clicks YES
                parent,
                "Are you sure you want to delete the selected item?",
                "Confirm Deletion",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
        ) == javax.swing.JOptionPane.YES_OPTION;
    }

    /**
     * @Desc: Displays an information dialog confirming that deletion was
     * successful.
     */
    public static void deleteSuccess(Component parent) {
        JOptionPane.showMessageDialog(  // Show information dialog
                parent,
                "Deleted successfully.",
                "Deletion successful",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
