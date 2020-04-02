 /**
 * This is the class of Customers Object.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"), Finished("Finished"), Cancelled("Cancelled");
    
    private String status;
    
    InvoiceStatus( String status){
        this.status = status;
    }
    
    public String toString(){
        return status;
    }
}
