package emailapp;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 100;

    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;


        this.department = setDepartment();
        System.out.println("Department is: " + this.department);


        this.password = managePasswords();

        this.email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + ".com";

    }

    public String setDepartment() {   /// The user sets the department
        Scanner s = new Scanner(System.in);
        int depChoice;
        String department = "";

        System.out.println("New worker: " + firstname + "\nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");

        do {
            System.out.print("Enter department code: ");
            while (!s.hasNextInt()) {
                System.out.println("That's not a valid number. Please enter 0, 1, 2, or 3.");
                s.next();
                System.out.print("Enter department code: ");
            }
            depChoice = s.nextInt();

            switch (depChoice) {
                case 1:
                    department = "sales";
                    break;
                case 2:
                    department = "dev";
                    break;
                case 3:
                    department = "acc";
                    break;
                case 0:
                    department = "none";
                    break;
                default:
                    System.out.println("Invalid department code. Please enter a number between 0 and 3.");
                    break;
            }
        } while (department.equals(""));

        return department;
    }


    private String randomPassword () { /// The program gives the user a random password.The users set the password lenght.


        Scanner s = new Scanner(System.in);
        System.out.print("Enter the desired password length (number of characters): ");
        int lenght = s.nextInt();
        String passwordSet = "ABCDEFGHIJKMNLOPRSTU4324821081!^(@*&%";
        char[] password = new char[lenght];
        for (int i = 0;i<lenght;i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return  new String(password);

    }

    public String managePasswords() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String password = ""; // Inițializăm variabila care va stoca parola finală

        System.out.println("How do you want your password to be generated?");
        System.out.println("1. Create your own password\n2. Generate a random password.");

        do {
            System.out.print("Enter your choice (1 or 2): ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid choice. Please enter 1 or 2.");
                scanner.next(); // Consumă inputul greșit
                System.out.print("Enter your choice (1 or 2): ");
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your new password: ");
                    password = scanner.next();
                    break;
                case 2:
                    password = randomPassword();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    break;
            }
        } while (choice != 1 && choice != 2);


        return password;
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }


    public void changePassword (String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }


    public String getPassword() {
        return password;
    }

    public void showInfo () {
        System.out.println("-".repeat(30));
        System.out.printf("Your email is: %s %nYour password is: %s %nMailbox capacity: %smb",email,password,mailboxCapacity);


    }

}
