package by.victor.greenhouse.builder.handler;

public class GreenhouseContentException extends RuntimeException {
    public GreenhouseContentException() {
    }

    public GreenhouseContentException(String message) {
        super(message);
    }

    public GreenhouseContentException(String message, Throwable cause) {
        super(message, cause);
    }

    public GreenhouseContentException(Throwable cause) {
        super(cause);
    }
}
