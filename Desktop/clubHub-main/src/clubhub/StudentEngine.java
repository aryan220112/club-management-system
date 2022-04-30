/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubhub;

import java.util.Scanner;

/**
 *
 * @author Aryan
 */
public class StudentEngine {

    //decalring the Club, and Student objects.
    Scanner input = new Scanner(System.in);
    Club club = new Club();
    Student newStudent = new Student();

    public void operations() {

        //variable contin to see if the user wants to continue
        String contin = "yes";
        do {
            System.out.println("\n\n");
            //promting the user to choose between 3 options available for Student side.
            System.out.println("What would you like to do?\n\n1-See the list of current clubs\n---------------------\n2-Become a member to a club\n---------------------\n"
                    + "3-Quit");
            int userAction = input.nextInt();

            switch (userAction) {

                //Getting and showing the list of current available clubs on the system
                case 1:

                    club.getClubData();
                    break;

                //Showing the available clubs and asking the user information and desired Club to be added to
                case 2:

                    club.getClubData();

                    //the Club id is asked to increase the size of the Club as the member gets added
                    System.out.println("\n\nEnter the id of the club you would like to join:");
                    int clubJoinId = input.nextInt();

                    //the Club name is asked to add the Student as a new member to the Club.
                    input.nextLine();
                    System.out.println("Enter the name of the club you would like to join:");
                    String clubJoinName = input.nextLine();

                    //promting the user for the information about them.
                    System.out.println("What is your First Name:");
                    String fname = input.nextLine();
                    System.out.println("What is your Last Name:");
                    String lname = input.nextLine();
                    System.out.println("What is your Grade:");
                    int grade = input.nextInt();
                    System.out.println("What is your student Number:");
                    int studentNum = input.nextInt();

                    //adds the Student to the Club
                    newStudent.addMember(clubJoinName, fname, lname, grade, studentNum);

                    //increase the Club size as the member gets added.
                    club.memberAdded(clubJoinId);

                    break;

                
                //if quit
                case 3:

                    System.out.println("\n\nSuccessfully quited");
                    System.exit(0);
                    break;

            }
            //asking the user if they would like to continue
            System.out.println("Would you like to continue");

            contin = input.next();
        } while (contin.equalsIgnoreCase("yes")); //continues operations untill the user doesn't want to do so

    }
}
