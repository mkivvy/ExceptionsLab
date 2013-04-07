package lab2;

import java.security.InvalidParameterException;

public class MissingDataException extends InvalidParameterException {

    private final static String MSG = "No value was entered";

    public MissingDataException() {
        super(MSG);
    }

    public MissingDataException(String missingDataMsg) {
        super(missingDataMsg);
    }
}
