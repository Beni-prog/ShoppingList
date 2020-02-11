package Domain;

public class Product {
    private int id;
    private String brand;
    private String name;
    private int price;
    private int quantity;

    public Product(int id, String brand, String name, int price, int quantity) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        if(this.quantity==0) {
            return id +
                    ","+ brand+
                    "," + name+
                    "," + price +
                    ","+"Out of stock!";
        }
        else
            return  id +
                    "," + brand +
                    "," + name +
                    "," + price +
                    "," + quantity;
    }
}
