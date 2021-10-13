package com.finTech;

import java.util.Scanner;

public class Main {
    private static Services service = new Services();

    public static void main(String[] args) {

        System.out.println("Welcome dear customer,\n");
        while(true){
            System.out.println("Enter:\n1) if you already have an account\n2) for creating a new account\n3) EXIT");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Enter your account number:");
                String account = in.next();
                Customer customer = service.getCustomer(account);
                System.out.println("Enter your pin:");
                int pin = in.nextInt();
                if (pin == customer.getPin()) {
                    System.out.println("Enter :\n1) to check balance\n2) to withdraw amount\n3) to deposit money\n4)change pin");
                    choice = in.nextInt();
                    long amount;
                    switch (choice) {
                        case 1:
                            service.getBalance(customer);
                            break;
                        case 2:
                            System.out.println("Enter the amount to be withdrawn:");
                            amount = in.nextLong();
                            service.withdraw(customer, amount);
                            break;
                        case 3:
                            System.out.println("Enter amount to be deposited:");
                            amount = in.nextLong();
                            service.deposit(customer, amount);
                            break;
                        case 4:
                            System.out.println("Enter previous pin");
                            pin = in.nextInt();
                            if (pin == customer.getPin()) {
                                System.out.println("Enter new pin:");
                                pin = in.nextInt();
                                service.changePin(customer, pin);
                            } else {
                                System.out.println("Wrong pin Entered");
                            }
                    }
                } else {
                    System.out.println("Invalid pin!");
                }
            }
            else if(choice==2){
                service.addCustomer();
            }
            else{
                break;
            }
        }
    }
}
