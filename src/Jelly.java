import java.util.Date;
public class Jelly extends Product {

    private String flavor;

    public Jelly(String initialCode, String initialDescription, double initialPrice, Date initialProductionDate, String initialShelfLife, String initialFlavor) {
        
        super(initialCode, initialDescription, initialPrice, initialProductionDate, initialShelfLife);
        flavor = initialFlavor;
    }

    public String getFlavor() {

        return flavor;
    }

    public String toString() {

        return "code：" + getCode() + "\ndescription：" + getDescription() + "\nprice：" + getPrice() + "\nproductionDate：" + getProductionDate() + "\nshelfLife：" + getShelfLife() + "\nflavor：" + flavor + "\n";
    }
}
