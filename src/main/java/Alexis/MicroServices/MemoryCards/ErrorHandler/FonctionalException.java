package Alexis.MicroServices.MemoryCards.ErrorHandler;

public class FonctionalException extends Exception{

    public FonctionalException(String message) {
        super(message);
    }

    public FonctionalException(String message, Throwable cause) {
        super(message, cause);
    }
}
