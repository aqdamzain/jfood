package aqdam.jfood;

public class OngoingInvoiceAlreadyExistsException extends Exception {
    Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input) {
        super("Ongoing Invoice! ");
        invoice_error = invoice_input;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + invoice_error.getId() + " " + invoice_error.getCustomer().getName();
    }
}
