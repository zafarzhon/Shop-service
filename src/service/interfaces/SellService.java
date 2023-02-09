package service.interfaces;

import model.Sell;

public interface SellService {
    void sell(String name,int count);
    void editSell(int id,int count);
    void deleteSell(int id);
    Sell[] getSellList();
}
