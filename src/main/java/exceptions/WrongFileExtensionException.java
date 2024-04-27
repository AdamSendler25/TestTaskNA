package exceptions;

public class WrongFileExtensionException extends Exception{
    public WrongFileExtensionException(String message) {
        super(message);
    }
}
