package splitter.Objects;
import java.util.ArrayList;
import java.util.List;
public class Purchases {

    static Purchases instance;
    List<Purchase> purchases;

    Purchases(){
        purchases = new ArrayList<>();
    }

    public static Purchases getInstance() {

        if(instance == null){
            instance = new Purchases();
        }

        return instance;
    }

    public void addPurchse(Purchase purchase){
        purchases.add(purchase);
    }

    public void removePurchases(Purchase purchase){
        purchases.remove(purchase);
    }
}
