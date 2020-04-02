import java.util.ArrayList;

public class DatabaseSeller
{
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Seller> getSellerDatabase(){
        return SELLER_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Seller getSellerById(int id){
        Seller rSeller = null;
        for (Seller seller: SELLER_DATABASE) {
            if(seller.getId()==id){
                rSeller = seller;
            }
        }
        return rSeller;
    }

    public static boolean addSeller(Seller seller){
        SELLER_DATABASE.add(seller);
        lastId = lastId + 1;
        return true;
    }

    public static boolean removeSeller(int id){
        boolean status = false;
        for (Seller seller: SELLER_DATABASE) {
            if(seller.getId()==id){
                status=true;
            }
        }
        if(status){
            SELLER_DATABASE.remove(id);
        }
        return status;
    }



}
