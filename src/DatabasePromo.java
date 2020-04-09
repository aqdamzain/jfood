import java.util.ArrayList;

public class DatabasePromo
{
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Promo> getPromoDatabase(){
        return PROMO_DATABASE;
    }

    public static int getLastId(){
        return  lastId;
    }

    public static Promo getPromoById(int id) throws PromoNotFoundException {
        Promo rPromo = null;
        boolean eVar = true;
        for (Promo fPromo: PROMO_DATABASE) {
            if(fPromo.getId()==id){
                rPromo = fPromo;
                eVar = false;
            }
        }
        if (eVar){
            throw new PromoNotFoundException(id);
        }
        return rPromo;
    }

    public static Promo getPromoByCode(String code){
        Promo rPromo = null;
        for (Promo fPromo: PROMO_DATABASE) {
            if(fPromo.getCode().equals(code)){
                rPromo = fPromo;
            }
        }
        return rPromo;
    }

    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException {
        boolean rVar = true;
        if(!(PROMO_DATABASE.isEmpty())){
            for (Promo fPromo: PROMO_DATABASE) {
                if(fPromo.getCode().equals(promo.getCode())){
                    rVar = false; }
            }
        }
        if(rVar){
            PROMO_DATABASE.add(promo);
            lastId = promo.getId();
        }else{
            throw new PromoCodeAlreadyExistsException(promo);
        }
        return rVar;
    }

    public static boolean activatePromo(int id){
        boolean rVar = false;
        for (Promo fPromo: PROMO_DATABASE) {
            if(fPromo.getId()==id){
                fPromo.setActive(true);
                rVar = true;
            }
        }
        return rVar;
    }

    public static boolean deactivatePromo(int id){
        boolean rVar = false;
        for (Promo fPromo: PROMO_DATABASE) {
            if(fPromo.getId()==id){
                fPromo.setActive(false);
                rVar = true;
            }
        }
        return rVar;
    }

    public static boolean removePromo(int id) throws PromoNotFoundException {
        boolean rVar = false;
        int promoIndex = -1;
        for (Promo fPromo: PROMO_DATABASE) {
            if(fPromo.getId()==id){
                promoIndex = PROMO_DATABASE.indexOf(fPromo);
                rVar = true;
            }
        }
        if(rVar){
            PROMO_DATABASE.remove(promoIndex);
        }else{
            throw new PromoNotFoundException(id);
        }
        return rVar;
    }

}
