package bookmap.dao;

import static bookmap.db.Storage.asks;
import static bookmap.db.Storage.bids;

import java.util.Map;

public class ShareDaoImpl implements ShareDao {
    @Override
    public void addToBidsMap(Integer price, Integer size) {
        bids.put(price, size);
    }

    @Override
    public void addToAsksMap(Integer price, Integer size) {
        asks.put(price, size);
    }

    @Override
    public void updateAsksMap(Integer size) {
        Map.Entry<Integer, Integer> minPriceAsk =
                asks.entrySet().stream().min(Map.Entry.comparingByKey()).get();
        asks.put(minPriceAsk.getKey(), minPriceAsk.getValue() - 1);
    }

    @Override
    public void updateBidsMap(Integer size) {
        Map.Entry<Integer, Integer> minPriceBid =
                bids.entrySet().stream().max(Map.Entry.comparingByKey()).get();
        bids.put(minPriceBid.getKey(), minPriceBid.getValue() - 1);
    }

    @Override
    public String getBestBid() {
        Map.Entry<Integer, Integer> bestBid =
                bids.entrySet().stream().max(Map.Entry.comparingByKey()).get();
        return "" + bestBid.getKey() + "," + bestBid.getValue();
    }

    @Override
    public String getBestAsk() {
        Map.Entry<Integer, Integer> bestAsk =
                asks.entrySet().stream().min(Map.Entry.comparingByKey()).get();
        return "" + bestAsk.getKey() + "," + bestAsk.getValue();
    }

    @Override
    public String getSizeByPrice(Integer price) {
        return bids.containsKey(price) ? "" + bids.get(price) : "" + asks.get(price);
    }
}
