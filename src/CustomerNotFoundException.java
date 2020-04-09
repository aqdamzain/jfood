public class CustomerNotFoundException extends Exception {
    private int customer_error;

    public CustomerNotFoundException(int customer_input) {
        super("Customer ID: ");
        customer_error = customer_input;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + customer_error + " not found";
    }
}
