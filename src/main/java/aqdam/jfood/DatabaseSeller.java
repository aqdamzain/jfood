package aqdam.jfood;
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

    public static Seller getSellerById(int id) throws SellerNotFoundException {
        Seller rSeller = null;
        boolean eVar = true;
        for (Seller seller: SELLER_DATABASE) {
            if(seller.getId()==id){
                rSeller = seller;
                eVar = false;
            }
        }
        if (eVar){
            throw new SellerNotFoundException(id);
        }
        return rSeller;
    }

    public static boolean addSeller(Seller seller){
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    public static boolean removeSeller(int id) throws SellerNotFoundException {
        boolean rVar = false;
        int sellerIndex = -1;
        for (Seller seller: SELLER_DATABASE) {
            if(seller.getId()==id){
                sellerIndex = SELLER_DATABASE.indexOf(seller);
                rVar=true;
            }
        }
        if(rVar){
            SELLER_DATABASE.remove(sellerIndex);
        }else{
            throw new SellerNotFoundException(id);
        }
        return rVar;
    }



}
