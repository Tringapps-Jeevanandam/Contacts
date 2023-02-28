package contacts;

import java.util.*;
import java.util.logging.Logger;
public class ContactMain {
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
