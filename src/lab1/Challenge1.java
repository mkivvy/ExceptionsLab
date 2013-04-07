package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    private static boolean invalidName = true;

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        String lastName = " ";
        String errorTitle = "Name Entry Error";
        
        while (invalidName) {
            try {
                String fullName = JOptionPane.showInputDialog("Enter full name:");
                lastName = app.extractLastName(fullName);
            } catch (MissingDataException mie ) {
                JOptionPane.showMessageDialog(null, mie.getMessage(), 
                        errorTitle, JOptionPane.ERROR_MESSAGE);
            } catch (InvalidDataEntryException ide ) {
                JOptionPane.showMessageDialog(null, ide.getMessage(), 
                        errorTitle, JOptionPane.ERROR_MESSAGE);
            }
        }
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        
    }
    
    public String extractLastName(String fullName)throws MissingDataException,
            InvalidDataEntryException {
        int NumberOfNamesRequired = 2;
        int minLastNameLength = 2;
        if (fullName == null || fullName.length() <= 0) {
            throw new MissingDataException
                    ("No name was entered.  Try again.");
        }
        String[] nameParts = fullName.split(" ");
        if (nameParts.length < NumberOfNamesRequired) {
            throw new InvalidDataEntryException
                    ("Not enough data was entered.  "
                    + "Please enter both your first and last names.");
        }
        if (nameParts.length > NumberOfNamesRequired) {
            throw new InvalidDataEntryException
                    ("Too much data was entered.  "
                    + "Please enter your first name, a space, "
                    + "and your last name.");
        }
        if (nameParts[LAST_NAME_IDX].length() < minLastNameLength) {
            throw new InvalidDataEntryException
                    ("Last name must be at least " + minLastNameLength
                    + " characters long.  Try again.");
        } 
        for (int i = 0; i < nameParts[LAST_NAME_IDX].length(); i++) {
            char thisChar = nameParts[LAST_NAME_IDX].charAt(i);
            //check if outside range of alphabetic characters and not a hyphen
            //in the unicode sequence
            if ((thisChar < 'A' || thisChar > 'z') && thisChar != '-') { 
            throw new InvalidDataEntryException
                    ("Last name must contain only letters.");
            }
            //check that the character is not one of the non-alphabetic characers
            //between 'Z' and 'a' in the unicode sequence
            if (thisChar > 'Z' && thisChar < 'a') {
            throw new InvalidDataEntryException
                    ("Last name must contain only letters.");
            }
        }
        if (nameParts[LAST_NAME_IDX].length() < minLastNameLength) {
            throw new InvalidDataEntryException
                    ("Last name must be at least " + minLastNameLength
                    + " characters long.  Try again.");
        } 
        invalidName = false;
        return nameParts[LAST_NAME_IDX];
    }

}
