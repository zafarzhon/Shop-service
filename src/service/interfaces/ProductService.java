package service.interfaces;

import model.Product;

public interface ProductService {
    void addProduct(String name, int count, double price);

    void updateProduct(String name, int count, double price);

    void deleteProduct(String name);

    Product[] getProductList();
}
