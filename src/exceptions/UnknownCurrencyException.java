package exceptions;

public class UnknownCurrencyException extends Exception {
    private static final long serialVersionUID = 1L;
    
    private String faultMessage;
    
    public UnknownCurrencyException() {
        super("UnknownCurrencyException");
    }
    
    public UnknownCurrencyException(String message) {
        this.faultMessage = message;
    }
    
    public void setFaultMessage(String message) {
        this.faultMessage = message;
    }
    
    @Override
    public String getMessage() {
        return faultMessage;
    }

}
