package exceptions;

public class RitualException extends Exception {
    public RitualException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Ошибка ритуала: " + super.getMessage();
    }
}

