package model;

public class Sell {
    private int id;
    private Product product;
    {
        id++;
    }

    public Sell(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "sellId: "+id+", Product info: "+product.toString();
    }
}
