package lab4;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) throws NullPointerException,
            InvalidNameException {
        int NumberOfNamesRequired = 2;
        int minLastNameLength = 2;
        if (fullName == null || fullName.length() <= 0) {
            throw new NullPointerException
                    ("No name was entered.  Try again.");
        }
        String[] nameParts = fullName.split(" ");
        if (nameParts.length < NumberOfNamesRequired) {
            throw new InvalidNameException();
        }
        if (nameParts.length > NumberOfNamesRequired) {
            throw new InvalidNameException();
        }
        if (nameParts[LAST_NAME_IDX].length() < minLastNameLength) {
            throw new InvalidNameException();
        }
        for (int i = 0; i < nameParts[LAST_NAME_IDX].length(); i++) {
            char thisChar = nameParts[LAST_NAME_IDX].charAt(i);
            //check if outside range of alphabetic characters and not a hyphen
            //in the unicode sequence
            if ((thisChar < 'A' || thisChar > 'z') && thisChar != '-') { 
                throw new InvalidNameException();
        }
            //check that the character is not one of the non-alphabetic characers
            //between 'Z' and 'a' in the unicode sequence
            if (thisChar > 'Z' && thisChar < 'a') {
                throw new InvalidNameException();
            }
        }
        if (nameParts[LAST_NAME_IDX].length() < minLastNameLength) {
            throw new InvalidNameException();
        } 
        return nameParts[LAST_NAME_IDX];
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) {
        String[] nameParts = fullName.split(" ");
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        return name.length();
    }
    
}
