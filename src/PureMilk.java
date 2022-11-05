import java.util.Date;
public class PureMilk extends Product {

    private String countryOfOrigin;
    private String butterfat;
    private String protein;
    
    public PureMilk(String initialCode, String initialDescription, double initialPrice, Date initialProductionDate, 
    String initialShelfLife, String initialCountryOfOrigin, String initialButterfat, String initialProtein) {

        super(initialCode, initialDescription, initialPrice, initialProductionDate, initialShelfLife);
        countryOfOrigin = initialCountryOfOrigin;
        butterfat = initialButterfat;
        protein = initialProtein;
    }

    public String getCountryOfOrigin() {

        return countryOfOrigin;
    }

    public String getButterfat() {

        return butterfat;
    }

    public String getProtein() {

        return protein;
    }

    public String toString() {

        return "code：" + getCode() + "\ndescription：" + getDescription() + "\nprice：" + getPrice() + "\nproductionDate：" + getProductionDate() + 
        "\nshelfLife：" + getShelfLife() + "\ncountryOfOrigin：" + countryOfOrigin + "\nbutterfat:" + butterfat + "\nprotein:" + protein + "\n";
    }

}
