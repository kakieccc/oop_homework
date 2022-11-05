import java.util.Date;
public class MilkDrink extends Product{

    private String flavor;
    private String sugar;

    public MilkDrink(String initialCode, String initialDescription, double initialPrice, Date initialProductionDate,
    String initialShelfLife, String initialFlavor, String initialSugar) {

        super(initialCode, initialDescription, initialPrice, initialProductionDate, initialShelfLife);
        flavor = initialFlavor;
        sugar = initialSugar;
    }

    public String getFlavor() {

        return flavor;
    }

    public String getSugar() {

        return sugar;
    }

    public String toString() {

        return "code：" + getCode() + "\ndescription：" + getDescription() + "\nprice：" + getPrice() + "\nproductionDate：" + getProductionDate() + 
        "\nshelfLife：" + getShelfLife() + "\nflavor：" + flavor + "\nsugar：" + sugar + "\n";
    }

}
