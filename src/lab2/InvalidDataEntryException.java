package lab2;

import java.security.InvalidParameterException;

public class InvalidDataEntryException  extends InvalidParameterException {

    private final static String MSG = "Invalid data entered";

    public InvalidDataEntryException() {
        super(MSG);
    }

    public InvalidDataEntryException(String invalidDataMsg) {
        super(invalidDataMsg);
    }

}

