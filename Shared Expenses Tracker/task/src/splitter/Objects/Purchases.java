package splitter.Objects;
import java.util.ArrayList;
import java.util.List;
public class Purchases {

    Purchases instance;
    List<Purchase> purchases;

    Purchases(){
        purchases = new ArrayList<>();
    }

    public Purchases getInstance() {

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
