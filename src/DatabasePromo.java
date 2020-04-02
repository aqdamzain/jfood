import java.util.ArrayList;

public class DatabasePromo
{
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Promo> etPromoDatabase(){
        return PROMO_DATABASE;
    }

    public static int getLastId(){
        return  lastId;
    }

    public static Promo getPromoById(int id){
        Promo rPromo = null;
        for (Promo promo: PROMO_DATABASE) {
            if(promo.getId()==id){
                rPromo = promo;
            }
        }
        return rPromo;
    }

    public static Promo getPromoByCode(String code){
        Promo rPromo = null;
        for (Promo promo: PROMO_DATABASE) {
            if(promo.getCode().equals(code)){
                rPromo = promo;
            }
        }
        return rPromo;
    }

    public static boolean addPromo(Promo promo){
        boolean status = false;
        for (Promo fPromo: PROMO_DATABASE) {
            if(!(fPromo.getCode().equals(promo.getCode()))){
                status = true;
                PROMO_DATABASE.add(promo);
                lastId = promo.getId();
            }
        }
        return status;
    }

    public static boolean activatePromo(int id){
        boolean status = false;
        for (Promo fPromo: PROMO_DATABASE) {
            if(fPromo.getId()==id){
                fPromo.setActive(true);
                status = true;
            }
        }
        return status;
    }

    public static boolean deactivatePromo(int id){
        boolean status = false;
        for (Promo fPromo: PROMO_DATABASE) {
            if(fPromo.getId()==id){
                fPromo.setActive(false);
                status = true;
            }
        }
        return status;
    }

    public static boolean removePromo(int id){
        boolean status = false;
        for (Promo promo: PROMO_DATABASE) {
            if(promo.getId()==id){
                status=true;
            }
        }
        if(status){
            PROMO_DATABASE.remove(id);
        }
        return status;
    }

}
