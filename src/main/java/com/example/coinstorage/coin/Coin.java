package com.example.coinstorage.coin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Coin")
public class Coin {
    @Id
    private String id;
    private String name;
    private long price;
    private long date;

    public Coin(String name, long price) {
        this.name = name;
        this.price = price;
        setDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Long getDate() {
        return date;
    }

    public void setDate() {
        this.date = System.currentTimeMillis();
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
