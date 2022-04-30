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
 * 
 */
public class AdminEngine {

  
    Admin admin = new Admin();
    Scanner input = new Scanner(System.in);
    Club club = new Club();
    Student newStudent = new Student();


    public void operations() {

     
        if (admin.checkAdmin()) {

      
            int id;
            String name;
            int size;
            String manager;
            String location;
            String contin = "yes";
            do {
                System.out.println("\n\n\n\n");
             
                System.out.println("What operation would you like to do?");
                System.out.println("1-Club Related\n---------------------\n2-Admin Related\n---------------------\n3-Quit");
                int userOperationChoice = input.nextInt();
               
                if (userOperationChoice == 1) {
                    System.out.println("\n\n\n\n");
                    System.out.println("What type of data you would like to work on?");
                    System.out.println("1-Club Information Related\n---------------------\n2-Club Members Related\n---------------------\n");
                    int userClubRelatedOperationChoice = input.nextInt();

                    if (userClubRelatedOperationChoice == 1) {
                        System.out.println("\n\n\n\n");
                        //prompts the user to choose between 4 options
                        System.out.println("Choose an option:");
                        System.out.println("1-Insert a new Club\n---------------------\n2-Get the list of current clubs\n---------------------\n"
                                + "3-Update a club\n---------------------\n4-Delete a club\n---------------------\n5-Quit");
                        int userClubInformationAction = input.nextInt();

                        switch (userClubInformationAction) {

                            //if Admin chooses to insert a Club
                            case 1:

                                
                                input.nextLine();
                                System.out.println("Enter the Club Name: ");
                                name = input.nextLine();

                                System.out.println("Enter the Club Size");
                                size = input.nextInt();

                                input.nextLine();
                                System.out.println("Enter the Club Manager Name");
                                manager = input.nextLine();

                                System.out.println("Enter the club Location");
                                location = input.nextLine();

                                
                                club.addClub(name, size, manager, location);
                                club.createClubTable(name);
                               

                                break;

                            
                            case 2:

                                club.getClubData();
                                break;

                            
                            case 3:
                                
                                System.out.println("See the list of clubs first");
                                club.getClubData();
                                
                                System.out.print("Enter the id of the club you would like to update: ");
                                id = input.nextInt();

                                
                                System.out.println("What would you like to update: ");
                                System.out.println("1-Name\n2-Size\n3-Manager\n4-Location");
                                int userUpdateChoice = input.nextInt();
                                switch (userUpdateChoice) {

                                    
                                    case 1:
                                        
                                        input.nextLine();
                                        System.out.println("Enter the new NAME: ");
                                        name = input.nextLine();
                                       
                                        club.changeName(id, name);
                                        break;

                                    
                                    case 2:
                                       
                                        input.nextLine();
                                        System.out.println("Enter the new SIZE: ");
                                        size = input.nextInt();
                                        
                                        club.changeSize(id, size);
                                        break;

                                    
                                    case 3:
                                        
                                        input.nextLine();
                                        System.out.println("Enter the new MANAGER: ");
                                        manager = input.nextLine();
                                        
                                        club.changeManager(id, manager);
                                        break;

                                    
                                    case 4:
                                        
                                        input.nextLine();
                                        System.out.println("Enter the new Location: ");
                                        location = input.nextLine();
                                        
                                        club.changeLocation(id, location);
                                        break;

                                }
                                break;

                            
                            case 4:
                                
                                club.getClubData();

                                
                                System.out.println("What is the id of the club you would like to delete?");
                                int userIdEntry = input.nextInt();
                                
                                input.nextLine();
                                System.out.println("What is the name of the club you would like to delete?");
                                String userNameEntry = input.nextLine();
                                
                                System.out.println("Are you sure of deleting " + userNameEntry + " with the id of " + userIdEntry + " ?");
                                String userAnswer = input.next();
                                
                                if (userAnswer.equalsIgnoreCase("yes")) {

                                    if (admin.checkPassword()) {

                                        
                                        club.deleteClub(userIdEntry);

                                        
                                        club.deleteClubTable(userNameEntry);
                                    } else {
                                       
                                        System.out.println("failed to delete");

                                    }
                                }
                                break;

                            case 5:
                                System.out.println("\n\nSuccessfully quited");
                                System.exit(0);
                                break;
                        }
                    } 
                    else if (userClubRelatedOperationChoice == 2) {
                        System.out.println("\n\n\n\n");
                        
                        System.out.println("Choose an option:");
                        System.out.println("1-Get the member list for a club\n---------------------\n2-Add a member to a Club\n---------------------\n"
                                + "3-Delete a member from a club\n---------------------\n4-Quit");
                        int userMembersAction = input.nextInt();

                        switch (userMembersAction) {

                            
                            case 1:
                                //shows the current list of clubs
                                club.getClubData();
                               
                                input.nextLine();
                                System.out.println("Enter the name of the club you would like to get the list of.");
                                String selectedClubName = input.nextLine();


                                club.memberList(selectedClubName);
                                break;
                  
                            case 2:

                                club.getClubData();

                                System.out.println("\n\nEnter the id of the club you would like to add the student to:");
                                int clubJoinMemberId = input.nextInt();

                                input.nextLine();
                                System.out.println("Enter the name of the club you would like to add the student to:");
                                String clubJoinMemberName = input.nextLine();

                                System.out.println("What is his/her First Name:");
                                String fname = input.nextLine();
                                System.out.println("What is his/her Last Name:");
                                String lname = input.nextLine();
                                System.out.println("What is his/her Grade:");
                                int grade = input.nextInt();
                                System.out.println("What is his/her student Number:");
                                int studentNum = input.nextInt();

                    
                                newStudent.addMember(clubJoinMemberName, fname, lname, grade, studentNum);


                                club.memberAdded(clubJoinMemberId);

                                break;
                            

                            case 3:

                                club.getClubData();

                 
                                System.out.println("\n\nEnter the id of the club you would like to add the student to:");
                                int clubDeleteMemberId = input.nextInt();


                                input.nextLine();
                                System.out.println("Enter the name of the club you would like to delete the student from:");
                                String clubDeleteMemberName = input.nextLine();

                            
                                club.memberList(clubDeleteMemberName);

                                System.out.println("What is his/her student Number:");
                                int DeletestudentNum = input.nextInt();

                                newStudent.deleteMember(clubDeleteMemberName, DeletestudentNum);

                                club.memberRemoved(clubDeleteMemberId);
                                break;
                            //if quits
                            case 4:
                                System.out.println("\n\nSuccessfully quited");
                                System.exit(0);
                                break;

                        }
                    
                    } else if (userClubRelatedOperationChoice == 3) {

                        System.out.println("\n\nSuccessfully quited");
                        System.exit(0);
                        
                    }

                } //if the Admin chooses to adjust admins
                else if (userOperationChoice == 2) {
                    System.out.println("\n\n\n\n");

                    System.out.println("Choose an option:");
                    System.out.println("1-Change Password\n---------------------\n2-Add a new admin\n---------------------\n3-Delete an admin\n---------------------\n4-Quit");
                    int userAdminAction = input.nextInt();
                    input.nextLine();
                    switch (userAdminAction) {

                        //if the Admin chooses to change the password
                        case 1:

                            //calls the Admin object to change the pass
                            admin.changePassword();

                            break;

                        //if the Admin chooses to add a new Admin
                        case 2:
                            //calls the Admin object to show the current list of admins
                            admin.getAdminList();

                            //calls the Admin object to insert a new Admin
                            admin.addAdmin();
                            break;

                        //if the Admin chooses to delete a Admin
                        case 3:
                            //calls the Admin object to show the current list of admins
                            admin.getAdminList();

                            //calls the Admin object to delete an Admin
                            admin.deleteAdmin();
                            break;
                        
                        //if quit
                        case 4:
                            System.out.println("\n\nSuccessfully quited");
                            System.exit(0);
                            break;

                    }
                //if quit
                } else if (userOperationChoice == 3) {
                    System.out.println("\n\nSuccessfully quited");
                    System.exit(0);

                }

                System.out.println("Would you like to continue");

                contin = input.next();

            } while (contin.equalsIgnoreCase(
                    "yes"));

        }

    }
}
