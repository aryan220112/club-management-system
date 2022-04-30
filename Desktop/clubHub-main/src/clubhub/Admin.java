package clubhub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aryan
 */
public class Admin {

    
    public static String username;
    public static String password;
    DataBaseCon db = new DataBaseCon();

    Scanner input = new Scanner(System.in);

    
    public void setUsername() {
        System.out.println("Enter the Username");
        username = input.nextLine();

    }

    
    public void setPassword() {

        System.out.println("Enter the Password");
        password = input.nextLine();

    }


    public String getUsername() {

        return username;
    }

    
    public String getPassword() {

        return password;
    }

    Connection adminCon() throws ClassNotFoundException {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Aryan@123");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

//check for admin in database
    public Boolean checkAdmin() {
        boolean loggedIn = false;
        
        int tryTimes = 0;
        do {

            tryTimes++;

            setUsername();
            setPassword();

            if (db.checkAdmin(getUsername(), getPassword())) {
                loggedIn = true;
            } else {
                loggedIn = false;
            }

        } while (loggedIn == false && tryTimes < 3); //if the unsuccesful entries are more than 3, it ends the program

        //if logged in return true
        if (loggedIn == true) {
            System.out.println("\n\n");
            System.out.println("Logged in");
            return true;
        } else {
            System.out.println("\n\n");
            System.out.println("Too many wrong entries. Try again later.");
            return false;
        }

    }

  
    public boolean checkPassword() {
        boolean currentPassMatched = true;

        do {

            System.out.println("To Confirm Your Identity, Please enter your cuurent password.");
            String userEntry = input.nextLine();
            
            if (userEntry.equals(getPassword())) {
                currentPassMatched = true;
            } else {
                currentPassMatched = false;
                System.out.println("password didn't match");
            }
        } while (currentPassMatched == false); 

        return currentPassMatched;

    }

    // change the Admin's password
    public void changePassword() {
        
        if (checkPassword()) {

            boolean newPassesMatched = true;
            do {
                
                System.out.println("Idetity Verfied, please enter your new password:");
                String userFirstEntry = input.nextLine();
                
                System.out.println("Please enter your new password again:");
                String userSecondEntry = input.nextLine();

                
                if (userFirstEntry.equals(userSecondEntry)) {
                    newPassesMatched = true;
                    String newPassword = userFirstEntry;

                    db.changePassword(getUsername(), newPassword);

                } else {
                    
                    newPassesMatched = false;
                    System.out.println("password didn't match");
                }
            } while (newPassesMatched == false); 

        }
    }

    //Adds an Admin to the adminlist
    public void addAdmin() {

        boolean matched = true;

        
        System.out.println("Enter a username of the new admin:");
        String newAdminUserName = input.nextLine();
        do {
            
            System.out.println("Enter a password for " + newAdminUserName);
            String newAdminFirstPasswordEntry = input.nextLine();
            
            System.out.println("Enter the password again for " + newAdminUserName);
            String newAdminSecondPasswordEntry = input.nextLine();

            
            if (newAdminFirstPasswordEntry.equals(newAdminSecondPasswordEntry)) {
                matched = true;
                String newAdminPassword = newAdminFirstPasswordEntry;
                db.addAdmin(newAdminUserName, newAdminPassword);
            } else {
                
                matched = false;
                System.out.println("Passwords are not matching.");
            }
        } while (matched == false); 

    }

    
    public void getAdminList() {
        System.out.println("Here is the list of current admins:\n");
        db.getAdminList();

    }

   //delete admin
    public void deleteAdmin() {

        boolean matched = false;

        do {
            
            System.out.println("Enter the username you want to delete");
            String deletedUsernameFirstEntry = input.nextLine();
            
            System.out.println("Enter the username you want to delete again");
            String deletedUsernameSecondEntry = input.nextLine();
            
            if (deletedUsernameFirstEntry.equals(deletedUsernameSecondEntry)) {
                matched = true;
                String deletedUsername = deletedUsernameFirstEntry;

                db.deleteAdmin(deletedUsername);
            } else {

                
                System.out.println("Didn't match");
                matched = false;
            }

        } while (matched == false); 

    }

}
