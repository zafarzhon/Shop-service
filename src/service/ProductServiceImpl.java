package service;

import data.Data;
import model.Product;
import service.interfaces.ProductService;

public enum ProductServiceImpl implements ProductService {
    PRODUCT_SERVICE;

    @Override
    public void addProduct(String name, int count, double price) {
        Data.DATA.addProduct(new Product(name, count, price));
    }

    @Override
    public void updateProduct(String name, int count, double price) {
        Product product = Data.DATA.getProductFromName(name);
        if (product != null) {
            product.setCount(count);
            product.setPrice(price);
        } else
            System.out.println("\u001B[31m" + "you want to change a non-existent product!" + "\u001B[0m");
    }

    @Override
    public void deleteProduct(String name) {
        Data.DATA.removeProduct(name);
    }

    @Override
    public Product[] getProductList() {
        return Data.DATA.getProducts();
    }
}
