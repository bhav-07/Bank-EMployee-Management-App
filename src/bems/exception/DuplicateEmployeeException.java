package bems.exception;

public class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}