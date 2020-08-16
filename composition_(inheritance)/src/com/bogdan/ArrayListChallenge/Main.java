package com.bogdan.ArrayListChallenge;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0230 789 525");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter action: (6 - to print a list of available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nSystem is shutting down...");
                    quit=true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4 :
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact(){
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: name = "+name+" phone number = "+phoneNumber);
        }else{
            System.out.println("Contact: "+name+" with "+phoneNumber+" already exists.");
        }
    }

    public static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord==null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newPhoneNumber);
        if(mobilePhone.updataContact(existingContactRecord, newContact)){
            System.out.println("Record successfully updated");
        }else{
            System.out.println("Error updating record.");
        }
    }

    public static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Contact successfully deleted.");
        }else{
            System.out.println("Error deleting contact.");
        }
    }

    public static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: "+existingContactRecord.getName()+" with phone number "+existingContactRecord.getPhoneNumber());
    }


    private static void startPhone(){
        System.out.println("Phone is starting...");
    }

    private static void printActions(){
        System.out.println("\nAvailable actions: \npress");
        System.out.println("\n 0 - to shutdown"
                        +  "\n 1 - to print contacts"
                        +  "\n 2 - to add a new contact"
                        +  "\n 3 - to update an existing contact"
                        +  "\n 4 - to remove an existing contact"
                        +  "\n 5 - query if a contact exists"
                        +  "\n 6 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }
}
