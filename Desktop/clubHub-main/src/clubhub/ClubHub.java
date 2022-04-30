package clubhub;

import java.util.Scanner;

public class ClubHub {

    public static void main(String[] args) {

        //declaring AdminEngine and StudentEngine objects
        AdminEngine adminOperation = new AdminEngine();
        StudentEngine studentOperation = new StudentEngine();
        Scanner input = new Scanner(System.in);

        //Prompting the user to identify wether they are an admin or a student.
        System.out.println("Select one of the above:\n1-Admin Login\n---------------------\n2-Client use\n---------------------\n3-Quit");
        int userChoice = input.nextInt();

        //admin
        if (userChoice == 1) {
            //calling the operations method from AdminEngine
            adminOperation.operations();

        } //student
        else if (userChoice == 2) {
            //calling the operations method from StudentEngine
            studentOperation.operations();

        } //if quit
        else if (userChoice == 3) {
            System.out.println("\n\nSucccessfuly Quited");
            System.exit(0);
        }
    }

}