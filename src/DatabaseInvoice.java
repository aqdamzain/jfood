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

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        boolean eVar = true;
        Invoice rInvoice = null;
        for (Invoice fInvoice: INVOICE_DATABASE) {
            if(fInvoice.getId()==id){
                rInvoice = fInvoice;
                eVar = false;
            }
        }
        if(eVar){
            throw new InvoiceNotFoundException(id);
        }
        return rInvoice;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId){
        ArrayList<Invoice> rInvoices = new ArrayList<>();
        for (Invoice fInvoice: INVOICE_DATABASE) {
            if(fInvoice.getCustomer().getId()==customerId){
                rInvoices.add(fInvoice);
            }
        }
        return rInvoices;
    }

    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        boolean rVar = true;
        Invoice eInvoice = null;
        for(Invoice fInvoice : INVOICE_DATABASE){
            if(fInvoice.getCustomer()==invoice.getCustomer()&&fInvoice.getInvoiceStatus()==InvoiceStatus.Ongoing){
                rVar = false;
                eInvoice = fInvoice;
            }
        }
        if(rVar){
            INVOICE_DATABASE.add(invoice);
            lastId = invoice.getId();
        }else{
            throw new OngoingInvoiceAlreadyExistsException(eInvoice);
        }
        return rVar;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        boolean rVar = false;
        for (Invoice fInvoice: INVOICE_DATABASE) {
            if(fInvoice.getId()==id&&fInvoice.getInvoiceStatus()==InvoiceStatus.Ongoing){
                fInvoice.setInvoiceStatus(invoiceStatus);
                rVar = true;
            }
        }
        return rVar;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
        boolean rVar = false;
        int invoiceIndex = -1;
        for (Invoice fInvoice: INVOICE_DATABASE) {
            if(fInvoice.getId()==id){
                invoiceIndex = INVOICE_DATABASE.indexOf(fInvoice);
                rVar = true;
            }
        }
        if(rVar){
            INVOICE_DATABASE.remove(invoiceIndex);
        }else{
            throw  new InvoiceNotFoundException(id);
        }
        return rVar;
    }


}
