import java.util.ArrayList;
public class DatabaseInvoice {

    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Invoice getInvoiceById(int id){
        Invoice rInvoice = null;
        for (Invoice invoice: INVOICE_DATABASE) {
            if(invoice.getId()==id){
                rInvoice = invoice;
            }
        }
        return rInvoice;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId){
        ArrayList<Invoice> rInvoices = new ArrayList<>();
        for (Invoice invoice: INVOICE_DATABASE) {
            if(invoice.getCustomer().getId()==customerId){
                rInvoices.add(invoice);
            }
        }
        return rInvoices;
    }

    public static boolean addInvoice(Invoice invoice){
        boolean temp = false;
        if(!(invoice.getInvoiceStatus()==InvoiceStatus.Ongoing)) {
            INVOICE_DATABASE.add(invoice);
            lastId = invoice.getId();
            temp = true;
        }
        return temp;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        boolean temp = false;
        for (Invoice invoice: INVOICE_DATABASE) {
            if(invoice.getId()==id&&invoice.getInvoiceStatus()==InvoiceStatus.Ongoing){
                invoice.setInvoiceStatus(invoiceStatus);
                temp = true;
            }
        }
        return temp;
    }

    public static boolean removeInvoice(int id){
        boolean temp = false;
        int index = -1;
        for (Invoice invoice: INVOICE_DATABASE) {
            if(invoice.getId()==id){
                index = INVOICE_DATABASE.indexOf(invoice);
                temp = true;
            }
        }
        if(temp){
            INVOICE_DATABASE.remove(index);
        }
        return temp;
    }


}
