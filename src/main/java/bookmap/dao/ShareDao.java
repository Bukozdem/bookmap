package bookmap.dao;

public interface ShareDao {
    void addToBidsMap(Integer price, Integer size);

    void addToAsksMap(Integer price, Integer size);

    void updateAsksMap(Integer size);

    void updateBidsMap(Integer size);

    String getBestBid();

    String getBestAsk();

    String getSizeByPrice(Integer price);
}
