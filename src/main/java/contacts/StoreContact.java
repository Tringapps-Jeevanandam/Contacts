package contacts;

import java.util.logging.*;

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
        if(this.head.next == null){
            this.head = null;
        } else{
        Contact curr = this.head;
        Contact prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
      }
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