package lab0;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 * In this challenge you need to address the probability that at some point the
 * arguments to method parameters may not be valid.
 * <p>
 * For example, String arguments may be null or empty; other objects may be
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all arguments
 * are valid. The only exception is when any argument is acceptable based on
 * requirements. Fix the code below using if logic to validate method arguments
 * and throw IllegalArgumentException or a custom exception if the validation
 * fails.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {

    public static final int MAX_VACATION_DAYS = 28;
    public static final int ZERO = 0;
    public static final int SSN_REQUIRED_LENGTH = 9;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        try {
            setFirstName(firstName);
            setLastName(lastName);
            setSsn(ssn);
            setHireDate(hireDate);
            setDaysVacation(daysVacation);
        } catch (MissingArgumentException ma) {
            System.out.println(ma.getMessage());
        } catch (IncorrectObjectArgumentException ioa) {
            System.out.println(ioa.getMessage());
        } catch (IllegalArgumentException ia) {
            System.out.println(ia.getMessage());
        }

    }

    public int getDaysVacation() {
        return daysVacation;
    }

    public final void setDaysVacation(int daysVacation)
            throws IllegalArgumentException {
        if (daysVacation < ZERO || daysVacation > MAX_VACATION_DAYS) {
            throw new IllegalArgumentException("Vacation days must be "
                    + "at least zero and no more than "
                    + MAX_VACATION_DAYS);
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName)
            throws MissingArgumentException {
        if (firstName == null || firstName.length() == 0) {
            throw new MissingArgumentException("First Name must contain a "
                    + "string of at least one character");
        }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public final void setHireDate(Date hireDate) throws MissingArgumentException,
            IncorrectObjectArgumentException {
        if (hireDate == null) {
            throw new MissingArgumentException("Hire Date must contain a "
                    + "valid date");
        } else if (!(hireDate instanceof Date)) {
            throw new IncorrectObjectArgumentException("Hire Date must contain"
                    + " a valid date type object");
        }
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName)
            throws MissingArgumentException {
        if (lastName == null || lastName.length() == 0) {
            throw new MissingArgumentException("Last Name must contain a "
                    + "string of at least one character");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    public final void setSsn(String ssn)
            throws MissingArgumentException, IllegalArgumentException {
        if (ssn == null || ssn.length() == 0) {
            throw new MissingArgumentException("Social Security Number must "
                    + "contain a string of " + SSN_REQUIRED_LENGTH
                    + " numeric characters");
        } else if (ssn.length() < SSN_REQUIRED_LENGTH
                || ssn.length() > SSN_REQUIRED_LENGTH) {
            throw new IllegalArgumentException("Social Security Number must "
                    + "be " + SSN_REQUIRED_LENGTH
                    + " numeric characters long");
        } else {
            char[] ssnChars = ssn.toCharArray();
            for (char c : ssnChars) {
                if (c < '0' || c > '9') {
                    throw new IllegalArgumentException("Social Security Number "
                            + " must contain " + SSN_REQUIRED_LENGTH
                            + " NUMERIC characters");
                }
            }
        }
        this.ssn = ssn;
    }
}
