package be.learningfever.testing.thermostat.exceptions;

public class InvalidTemperatureException extends RuntimeException {
    public InvalidTemperatureException() {
    }

    public InvalidTemperatureException(String message) {
        super(message);
    }

    public InvalidTemperatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTemperatureException(Throwable cause) {
        super(cause);
    }

    public InvalidTemperatureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
