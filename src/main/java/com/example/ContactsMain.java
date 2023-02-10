package com.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Contact {
    String name;
    long phNo;
    String email;
    Contact next;

    Contact(String name, long phNo, String email) {
        this.name = name;
        this.phNo = phNo;
        this.email = email;
        next = null;
    }

}

class StoreContact {
    Contact head;

    StoreContact() {
        head = null;
    }

    public static final Logger Log = Logger.getLogger("InfoLogging");

    public void addContact(String name, long phNo, String email) {
        Contact newContact = new Contact(name, phNo, email);
        if (this.head == null) {
            this.head = newContact;
        } else {
            Contact temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newContact;
        }
    }

    public void delete() {
        Contact curr = this.head;
        Contact prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }

    public void delete(String name) {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (this.head.name.equals(name)) {
            this.head = this.head.next;
        }
        Contact temp = head;
        Contact prev = null;
        while (!temp.name.equals(name)) {
            if (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
        }
        prev.next = temp.next;
    }

    public void search(String name) {
        String srch;
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (this.head.name.equals(name)) {
            srch = "Name - " + this.head.name + " Ph Number - " + this.head.phNo + " Email - " + this.head.email;
            Log.info(srch);
        } else {
            Contact temp = head;
            while (!temp.name.equals(name)) {
                if (temp.next != null) {
                    temp = temp.next;
                }
            }
            srch = "Name: " + temp.name + " Ph Number: " + temp.phNo + " Email:" + temp.email;
            Log.info(srch);
        }

    }

    public void display() {
        Contact temp = head;
        String print;
        while (temp != null) {
            print = "Name-> " + temp.name + " Ph Number-> " + temp.phNo + " Email-> " + temp.email;
            temp = temp.next;
            Log.info(print);
        }
    }

}

public class ContactsMain {
    public static final Logger Log = Logger.getLogger("InfoLogging");

    public static void main(String[] args) {
        StoreContact con = new StoreContact();
        Scanner input = new Scanner(System.in);
        int flag = 0;
        do {
            Log.info("1.Add contact 2.Delete contact 3.Search 4.display 5.Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    Log.info("Enter Name:");
                    String name = input.next();
                    Log.info("Enter Number");
                    int phNo = input.nextInt();
                    Log.info("Enter E-mail:");
                    String email = input.next();
                    con.addContact(name, phNo, email);
                }
                    break;
                case 2: {
                    Log.info("1.Delete last contact 2.Delete Number");
                    int op = input.nextInt();
                    if (op == 1) {
                        con.delete();
                    } else if (op == 2) {
                        Log.info("Enter Number");
                        String name = input.next();
                        con.delete(name);
                    }
                }
                    break;
                case 3: {
                    Log.info("Enter Name: ");
                    String name = input.next();
                    con.search(name);
                }
                    break;
                case 4:
                    con.display();
                    break;
                case 5:
                    flag = 1;
                    break;
                default:
                    Log.info("Enter Correct choice");
            }

        } while (flag == 0);

    }
}
