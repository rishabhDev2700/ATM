package com.finTech;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Services {
    Scanner in = new Scanner(System.in);
    static List<Customer> customers = new LinkedList<>();
    public Customer getCustomer(String account){
        for(Customer customer:customers){
            if(customer.getAccount_number().equals(account)){
                return customer;
            }
        }
        return null;
    }
    public void addCustomer() {
        Random rn = new Random();
        String name, account_number;
        int pin, confirm_pin;
        System.out.println("Enter your name:");
        name = in.nextLine();
        System.out.println("Enter a pin for accessing your account:");
        pin = in.nextInt();
        System.out.println("\b\b\b\b");
        System.out.println("Re-enter your pin:");
        confirm_pin = in.nextInt();
        System.out.println("\b\b\b\b");
        account_number = String.valueOf(rn.nextInt(10000000));
        if (pin != confirm_pin) {
            System.out.println("Pin didn't match retry :(");
        }
        System.out.println(account_number + " is the account number assigned to you.");
        Customer new_customer = new Customer(name, account_number, pin);
        customers.add(new_customer);
        System.out.println("Customer added Successfully");
    }

    public void getBalance(Customer customer) {
        System.out.println(customer.getBalance());
    }

    public void withdraw(Customer customer, long amount) {
        if (amount > customer.getBalance()) {
            System.out.println("Insufficient Balance.");
        } else {
            System.out.println("Please Collect the amount :)");
            customer.setBalance(customer.getBalance() - amount);
        }
    }

    public void deposit(Customer customer, long amount) {
        if (amount > 0) {
            customer.setBalance(customer.getBalance() + amount);
            System.out.println("Amounted deposited:" + amount);
            System.out.println("Balance:" + customer.getBalance());
        } else {
            System.out.println("Invalid amount entered");
        }
    }
    public void changePin(Customer customer,int pin){
        customer.setPin(pin);
        System.out.println("Pin changed successfully");
    }
}
