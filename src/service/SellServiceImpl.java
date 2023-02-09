package service;

import data.Data;
import model.Product;
import model.Sell;
import service.interfaces.SellService;

public class SellServiceImpl implements SellService {
    public static final SellService SELL_SERVICE = new SellServiceImpl();
    private SellServiceImpl(){}

    @Override
    public void sell(String name, int count) {
        Product product = Data.getInstance().getProductFromName(name);
        if(product!=null){
            Data.getInstance().sellProduct(name,count,product);
        }else
            System.out.println("\u001B[31m" + "you want to add a non-existent product!" + "\u001B[0m");
    }

    @Override
    public void editSell(int id, int count) {
        Sell sell = Data.getInstance().getSellFromId(id);
        if(sell!=null){
            Data.getInstance().updateSell(sell,count);
        }else
            System.out.println("\u001B[31m" + "you want to change a non-existent sell!" + "\u001B[0m");
    }

    @Override
    public void deleteSell(int id) {
        Data.getInstance().removeSell(id);
    }

    @Override
    public Sell[] getSellList() {
        return Data.getInstance().getSells();
    }
}


