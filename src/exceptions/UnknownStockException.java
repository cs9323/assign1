package exceptions;

public class UnknownStockException extends Exception {
    private static final long serialVersionUID = 1L;
   
    private String faultMessage;
    
    public UnknownStockException() {
        super("UnknownStockException");
    }
    
    public UnknownStockException(String message) {
        this.faultMessage = message;
    }
    
    @Override
    public String getMessage() {
        return faultMessage;
    }
}
