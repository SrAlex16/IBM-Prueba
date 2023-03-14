package exceptions;

public class NoDataException extends Exception { 
    public NoDataException(String errorMessage) {
        super(errorMessage);
    }
}