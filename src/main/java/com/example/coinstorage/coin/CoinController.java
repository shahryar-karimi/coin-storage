package com.example.coinstorage.coin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coin")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @PostMapping("data/in")
    public String collectData(@RequestBody List<Coin> coins) {
        for (Coin coin : coins) {
            coinService.saveNewCoin(coin);
        }
        return "Data saved";
    }

    @GetMapping("{coinName}")
    public List<Coin> getPrice(@PathVariable String coinName) {
        return coinService.getPrice(coinName);
    }

    @GetMapping("{coinName}/{timeMillis}")
    public String getPrice(@PathVariable String coinName, @PathVariable long timeMillis) {
        String result;
        Coin coin = coinService.getPrice(coinName, timeMillis);
        if (coin == null) {
            result = "coin not found";
        } else {
            result = coin.getPrice() + " cent";
        }
        return result;
    }

    @GetMapping("{coinName}/{fromTimeMillis}/{toTimeMillis}")
    public List<Coin> getPrice(@PathVariable String coinName, @PathVariable long fromTimeMillis, @PathVariable long toTimeMillis) {
        return coinService.getPrice(coinName, fromTimeMillis, toTimeMillis);
    }
}
