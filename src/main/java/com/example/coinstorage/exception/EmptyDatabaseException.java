package com.example.coinstorage.exception;

public class EmptyDatabaseException extends Exception{
    public EmptyDatabaseException() {
        super("No data set for database");
    }
}
