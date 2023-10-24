public class ItemUI {
    private String itemName;
    private double price;
    private String itemType;
    
    public ItemUI() {
        itemName = "";
        price = 0.00;
        itemType = "";
    }

    public ItemUI(String itemName, double price, String itemType) {
        this.setItemType(itemType);
        this.setItemName(itemName);
        this.setPrice(price);
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemType() {
        return this.itemType;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}   