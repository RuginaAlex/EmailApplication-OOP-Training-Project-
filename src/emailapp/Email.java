package emailapp;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        System.out.println("Email create : " + this.firstname + this.lastname);

        this.department = setDepartment();
        System.out.println("Department is: " + this.department);
    }

    public String setDepartment() {
        System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner s = new Scanner(System.in);
        int depChoice = s.nextInt();
        switch (depChoice){
            case 1:
                return "Sales";
            case 2:
                return "dev";
            case 3:
                return "acc";
            default:
                return "";

        }

    }
}
