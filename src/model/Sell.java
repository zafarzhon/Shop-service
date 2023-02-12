package model;

import data.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sell {
    private int id;
    private Product product;

    private final LocalDateTime localDateTime;

    {
        localDateTime = LocalDateTime.now();
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n   Product info: " + product.toString()+"\n   "+"Time: "+localDateTime.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy hh:mm:ss"));
    }
}
