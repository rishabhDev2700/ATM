package com.finTech;

public class Customer {
    private String name;
    private String account_number;
    private int pin;
    private long balance = 0;

    Customer(String name, String account_number, int pin) {
        this.name = name;
        this.account_number = account_number;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public int getPin() {
        return pin;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
