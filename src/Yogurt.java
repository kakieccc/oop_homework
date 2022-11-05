import java.util.Date;
public class Yogurt extends Product{

    private String type;
    private String diluteConcentration;

    public Yogurt(String initialCode, String initialDescription, double initialPrice, Date initialProductionDate, String initialShelfLife, String initialType, String initialDiluteConcentration) {

        super(initialCode, initialDescription, initialPrice, initialProductionDate, initialShelfLife);
        type = initialType;
        diluteConcentration = initialDiluteConcentration;
    }

    public String getType() {

        return type;
    }

    public String getDiluteConcentration() {

        return diluteConcentration;
    }

    public String toString() {
        return "code：" + getCode() + "\ndescription：" + getDescription() + "\nprice：" + getPrice() + "\nproductionDate：" + getProductionDate() + 
        "\nshelfLife：" + getShelfLife() + "\ntype：" + type + "\ndiluteconcentration：" + diluteConcentration + "\n";
    }
    
}
