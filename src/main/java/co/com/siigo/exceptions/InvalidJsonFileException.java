package co.com.siigo.exceptions;

public class InvalidJsonFileException extends RuntimeException {

    public InvalidJsonFileException(String message) {
        super(message);
    }

    public InvalidJsonFileException(String message, Throwable cause) {
        super(message, cause);
    }
}