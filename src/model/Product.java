package model;

public class Product {
    private String name;
    private int count;
    private double price;
    public Product(String name, int count, double price) {
        setName(name.trim());
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank() || name.length()>30){
            throw new Error("Error name");
        }
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count<0){
            throw new Error("Error count");
        }
        this.count = count;
    }

    public void addCount(int count){
        this.count+=count;
    }
    public void subCount(int count){
        this.count-= count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<0){
            throw new Error("Error price");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: "+name+", count: "+count+", price: "+price;
    }
}
