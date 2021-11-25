package com.example.coinstorage.coin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    @Autowired
    private CoinRepository repository;

    public void saveNewCoin(Coin coin) {
        coin.setDate();
        repository.save(coin);
    }

    public List<Coin> getPrice(String coinName) {
        return repository.getCoinsByName(coinName);
    }

    public Coin getPrice(String coinName, long timeStamp) {
        long from = timeStamp - 10 * 60 * 1000;
        List<Coin> lastUpdate = getPrice(coinName, from, timeStamp);
        if (lastUpdate.isEmpty()) return null;
        else return lastUpdate.get(lastUpdate.size() - 1);
    }

    public List<Coin> getPrice(String coinName, long from, long to) {
        return repository.findByNameAndDateBetween(coinName, from, to);
    }
}
