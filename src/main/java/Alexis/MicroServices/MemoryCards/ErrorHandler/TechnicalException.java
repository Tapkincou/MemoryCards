package Alexis.MicroServices.MemoryCards.ErrorHandler;

public class TechnicalException extends Exception{

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
