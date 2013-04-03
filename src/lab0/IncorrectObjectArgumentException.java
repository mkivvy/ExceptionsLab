package lab0;

public class IncorrectObjectArgumentException extends IllegalArgumentException {

    private final static String MSG = "The parameter is not the correct "
            + "type of object ";
    private Exception cause;

    public IncorrectObjectArgumentException() {
        super(MSG);
    }

    public IncorrectObjectArgumentException(String incorrectObjectStr) {
        super(incorrectObjectStr);
    }

    public IncorrectObjectArgumentException(String incorrectObjectStr, 
            Throwable cause) {
        super(incorrectObjectStr, cause);
    }

    public IncorrectObjectArgumentException(Throwable cause) {
        super(cause);
    }
}
