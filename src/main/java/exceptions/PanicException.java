package exceptions;

public class PanicException extends RuntimeException {
    public PanicException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Паника! " + super.getMessage();
    }
}

