package lab0;

import java.security.InvalidParameterException;

public class MissingArgumentException extends InvalidParameterException {

    private final static String MSG = "No value was entered";

    public MissingArgumentException() {
        super(MSG);
    }

    public MissingArgumentException(String missingArgumentData) {
        super(missingArgumentData);
    }
}
