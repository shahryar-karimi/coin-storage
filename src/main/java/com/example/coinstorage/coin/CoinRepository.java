package com.example.coinstorage.coin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends CrudRepository<Coin, String> {

    List<Coin> findByDateBetween(long from, long to);

    List<Coin> findByNameAndDateBetween(String name, long from, long to);

    List<Coin> getCoinsByName(String name);
}
