import java.util.Date;

public class Product {

	private String code;
    private String description;
    private double price;
    private Date productionDate;
    private String shelfLife;
    
    public Product(String initialCode, String initialDescription, double initialPrice, Date initialProductionDate, String initialShelfLife){
    	
    	code = initialCode;
        description = initialDescription;
        price = initialPrice;
        productionDate = initialProductionDate;
    	shelfLife = initialShelfLife;
    }
    
    public String getCode(){
    	
    	return code;
    }
    
    public String getDescription() {
    	
    	return description;
    }
    
    public double getPrice() {
    	
    	return price;
    }

    public Date getProductionDate() {

        return productionDate;
    }

    public String getShelfLife() {
        
        return shelfLife;
    }
    
    public String toString() {

    	return "code：" + code + "\ndescription：" + description + "\nprice：" + price + "\nproductionDate：" + productionDate + "\nshelfLife：" + shelfLife + "\n";
    }
    public static void main(String[] args) {

        Date date = new Date();
        Product[] p = new Product[4];
        p[0] = new Jelly("jellycode", "jellydescription", 100.00, date, "jellyshelflife", "jellyflavor");
        p[1] = new MilkDrink("milkdrinkcode", "milkdrinkdescription", 200.00, date, "milkdrinkshelflife", "milkdrinkflavor", "milkdrinksugar");
        p[2] = new Yogurt("yogurtcode", "yogurtdescription", 300.00, date, "yogurtshelflife", "yogurttype", "yogurtdiluteconcentration");
        p[3] = new PureMilk("puremilkcode", "puremilkdescription", 400.00, date, "puremilkshelflife", "puremilkcountryoforigin", "puremilkbufferfat", "puremilkmilkprotein");
        for(int i = 0; i < 4; i++){
            System.out.println(p[i].toString());
        }
    }
    
}
