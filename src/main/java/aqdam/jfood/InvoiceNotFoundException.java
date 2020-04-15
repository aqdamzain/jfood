package aqdam.jfood;

public class InvoiceNotFoundException extends Exception {
    int invoice_error;

    public InvoiceNotFoundException(int invoice_input) {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + invoice_error + " not found";
    }
}
