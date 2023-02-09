package service;

import data.Data;
import model.Product;
import service.interfaces.ProductService;

public class ProductServiceImpl implements ProductService {
    public static ProductService productService = null;
    private ProductServiceImpl(){}
    public static ProductService getInstance(){
        if(productService==null){
            return new ProductServiceImpl();
        }
        return productService;
    }
    @Override
    public void addProduct(String name,int count,double price) {
        Data.getInstance().addProduct(new Product(name,count,price));
    }
    @Override
    public void updateProduct(String name,int count,double price) {
        Product product = Data.getInstance().getProductFromName(name);
        if(product!=null){
            product.setCount(count);
            product.setPrice(price);
        }else
            System.out.println("\u001B[31m" + "you want to change a non-existent product!" + "\u001B[0m");
    }
    @Override
    public void deleteProduct(String name) {
        Data.getInstance().removeProduct(name);
    }
    @Override
    public Product[] getProductList() {
        return Data.getInstance().getProducts();
    }
}