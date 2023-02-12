package data;

import model.Product;
import model.Sell;

import java.util.Arrays;

public enum Data {
    DATA;

    private int p;
    private int s;
    private static Data data = null;

    private Product[] products = new Product[10];
    private Sell[] sells = new Sell[10];


    public void addProduct(Product product) {
        if (p >= products.length) increaseProductArray();
        products[p++] = product;
    }

    public void sellProduct(String name, int count, Product product) {
        if (product.getCount() < count) {
            System.out.println("\u001B[31m" + "the quantity of the product is not enough!" + "\u001B[0m");
            return;
        }
        product.subCount(count);
        addSell(new Sell(new Product(product.getName(), count, product.getPrice())));
        System.out.println("Success");
    }

    public void addSell(Sell sell) {
        if (s >= sells.length) increaseSellArray();
        sells[s++] = sell;
    }

    public void updateSell(Sell sell, int count) {
        Product product = this.getProductFromName(sell.getProduct().getName());
        if (product != null) {
            Product productInSell = sell.getProduct();
            if (productInSell.getCount() > count) {
                product.addCount(sell.getProduct().getCount() - count);
                productInSell.setCount(count);
                System.out.println("Success");
            } else if (productInSell.getCount() != count) {
                if (product.getCount() >= count - productInSell.getCount()) {
                    product.subCount(count - productInSell.getCount());
                    productInSell.setCount(count);
                    System.out.println("Success");
                } else
                    System.out.println("\u001B[31m" + "the quantity of the product is not enough!" + "\u001B[0m");
            }
        } else
            System.out.println("\u001B[31m" + "not possible, since this product is cleared from the data!" + "\u001B[0m");
    }

    public Product getProductFromName(String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getName().equalsIgnoreCase(name)) {
                return products[i];
            }
        }
        return null;
    }

    public Sell getSellFromId(int id) {
        for (int i = 0; i < sells.length; i++) {
            if (sells[i] != null && sells[i].getId() == id) {
                return sells[i];
            }
        }
        return null;
    }

    public void removeProduct(String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getName().equalsIgnoreCase(name)) {
                products[i] = products[--p];
                products[p] = null;
                System.out.println("Success");
                return;
            }
        }
        System.out.println("\u001B[31m" + "such a product with a name does not exist!" + "\u001B[0m");

    }

    public void removeSell(int id) {
        for (int i = 0; i < sells.length; i++) {
            if (sells[i] != null && sells[i].getId() == id) {
                sells[i] = sells[--s];
                sells[s] = null;
                System.out.println("Success");
                return;
            }
        }
        System.out.println("\u001B[31m" + "such a sell with an id does not exist!" + "\u001B[0m");
    }

    public Product[] getProducts() {
        return Arrays.copyOf(products, p);
    }

    public Sell[] getSells() {
        return Arrays.copyOf(sells, s);
    }

    private void increaseProductArray() {
        Product[] newProducts = new Product[(int) (products.length * 1.5 + 1)];
        for (int i = 0; i < products.length; i++) {
            newProducts[i] = products[i];
        }
        products = newProducts;
    }

    private void increaseSellArray() {
        Sell[] newSells = new Sell[(int) (sells.length * 1.5 + 1)];
        for (int i = 0; i < sells.length; i++) {
            newSells[i] = sells[i];
        }
        sells = newSells;
    }

}
