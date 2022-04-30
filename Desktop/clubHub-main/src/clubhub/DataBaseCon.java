/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubhub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aryan
 */
public class DataBaseCon {

    Connection clubsCon() throws ClassNotFoundException {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Aryan@123");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    Connection clubPostsCon() throws ClassNotFoundException {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubposts", "root", "Aryan@123");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
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

    //database configuration to insert a new Club
    void insertData(String clubName, int clubSize, String clubManager, String clubLocation) {

        try {

            //using prepared statement to insert a new Club
            PreparedStatement stmt = clubsCon().prepareStatement("INSERT INTO clublist (name, size, manager, location) VALUES (?, ?, ?, ?)");
            stmt.setString(1, clubName);
            stmt.setInt(2, clubSize);
            stmt.setString(3, clubManager);
            stmt.setString(4, clubLocation);
            stmt.execute();
            System.out.println("Succesfully added the new Club.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //database configuration to get the list of clubs
    void getData() {

        int clubId;
        String clubName;
        int clubSize;
        String clubManager;
        String clubLocation;
        try {
            //using prepared statement to get the list of clubs
            Statement stmt = clubsCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clublist");
            while (rs.next()) {

                clubId = rs.getInt("id");
                clubName = rs.getString("name");
                clubSize = rs.getInt("size");
                clubManager = rs.getString("manager");
                clubLocation = rs.getString("location");
                System.out.println("ID: " + clubId);
                System.out.println("Name: " + clubName);
                System.out.println("Size: " + clubSize);
                System.out.println("Manager: " + clubManager);
                System.out.println("Location: " + clubLocation);
                System.out.println("");
                System.out.println("");

            }
        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //database configuration to update a Club's name
    void updateDataName(int clubCurrentid, String clubNewName) {

        try {

            //using prepared statement to update a Club's name
            PreparedStatement stmt = clubsCon().prepareStatement("UPDATE clublist SET name = ? WHERE id = ?");

            stmt.setString(1, clubNewName);

            stmt.setInt(2, clubCurrentid);

            stmt.executeUpdate();
            System.out.println("Succesfully Updated.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //database configuration to update a Club's size
    void updateDataSize(int clubCurrentid, int clubNewSize) {

        try {

            //using prepared statement to update a Club's size
            PreparedStatement stmt = clubsCon().prepareStatement("UPDATE clublist SET size = ? WHERE id = ?");

            stmt.setInt(1, clubNewSize);

            stmt.setInt(2, clubCurrentid);

            stmt.executeUpdate();
            System.out.println("Succesfully Updated.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //database configuration to update a Club's manager
    void updateDataManager(int clubCurrentid, String clubNewManager) {

        try {
            //using prepared statement to update a Club's manager
            PreparedStatement stmt = clubsCon().prepareStatement("UPDATE clublist SET manager = ? WHERE id = ?");

            stmt.setString(1, clubNewManager);

            stmt.setInt(2, clubCurrentid);

            stmt.executeUpdate();
            System.out.println("Succesfully Updated.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //database configuration to update a Club's location
    void updateDataLocation(int clubCurrentid, String clubNewLocation) {

        try {
            //using prepared statement to update a Club's location
            PreparedStatement stmt = clubsCon().prepareStatement("UPDATE clublist SET location  = ? WHERE id = ?");

            stmt.setString(1, clubNewLocation);

            stmt.setInt(2, clubCurrentid);

            stmt.executeUpdate();
            System.out.println("Succesfully Updated.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //database configuration to create a table for the members of the Club
    void createTable(String tableName) {

        try {
            //using prepared statement to create a table for the members of the Club
            PreparedStatement stmt = clubsCon().prepareStatement("CREATE TABLE `" + tableName + "` (id int(100) PRIMARY KEY AUTO_INCREMENT NOT NULL,  firstname varchar(100) NOT NULL, lastname varchar(100) not null, grade int not null, studentnumber int not null);");

            stmt.executeUpdate();
            System.out.println("Succesfully Created the Member Table.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

    //database configuration to delete a Club information
    void deleteClub(int id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Aryan@123");
            //using prepared statement to delete a Club information
            PreparedStatement stmt = clubsCon().prepareStatement("DELETE FROM clublist WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Succesfully Deleted the Club.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //database configuration to delete a Club table for members and posts
    void deleteTable(String tableName) {

        try {
            //using prepared statement to delete a Club table for members 
            PreparedStatement stmt = clubsCon().prepareStatement("DROP TABLE `" + tableName + "`;");

            stmt.executeUpdate();
            System.out.println("Succesfully Deleted the Member Table.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

       

    }

    //database configuration to add a member for a Club
    void addMember(String clubName, String fname, String lname, int grade, int studentNum) {

        try {
            //using prepared statement to add a member for a Club
            PreparedStatement stmt = clubsCon().prepareStatement("INSERT INTO `" + clubName + "` (firstname, lastname, grade, studentnumber) VALUES (?, ?, ?, ?)");
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setInt(3, grade);
            stmt.setInt(4, studentNum);
            stmt.execute();
            System.out.println("Succesfully added the new member.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //database configuration to increase the size of a Club after adding a member
    void memberIncreased(int clubId) {

        int currentSize = 0;
        try {
            //using prepared statement to increase the size of a Club after adding a member
            String query = "SELECT * FROM clublist WHERE id = ?";
            PreparedStatement stmt = clubsCon().prepareStatement(query);
            stmt.setInt(1, clubId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                currentSize = rs.getInt("size");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement stmt = clubsCon().prepareStatement("UPDATE clublist SET size = ? WHERE  id = ?");
            stmt.setInt(1, currentSize + 1);
            stmt.setInt(2, clubId);

            stmt.execute();
            System.out.println("Succesfully Increased the size.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //database configuration to add a member for a Club
    void deleteMember(String clubName, int studentNum) {

        try {
            //using prepared statement to add a member for a Club
            PreparedStatement stmt = clubsCon().prepareStatement("DELETE FROM `" + clubName + "` WHERE studentnumber = ?");
            stmt.setInt(1, studentNum);
            stmt.execute();
            System.out.println("Succesfully deleted the member");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void memberDecreased(int clubId) {

        int currentSize = 0;
        try {
            //using prepared statement to increase the size of a Club after adding a member
            String query = "SELECT * FROM clublist WHERE id = ?";
            PreparedStatement stmt = clubsCon().prepareStatement(query);
            stmt.setInt(1, clubId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                currentSize = rs.getInt("size");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement stmt = clubsCon().prepareStatement("UPDATE clublist SET size = ? WHERE  id = ?");
            stmt.setInt(1, currentSize - 1);
            stmt.setInt(2, clubId);

            stmt.execute();
            System.out.println("Succesfully Decreased the Size.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //database configuration to get the list of members of a Club
    void getMemberList(String name) {
        int studentId;
        String studentFirstName;
        String studentLastName;
        int studentGrade;
        int studentStudentNumber;
        try {
            //using create statement to get the list of members of a Club
            Statement stmt = clubsCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `" + name + "`");
            while (rs.next()) {

                studentId = rs.getInt("id");
                studentFirstName = rs.getString("firstname");
                studentLastName = rs.getString("lastname");
                studentGrade = rs.getInt("grade");
                studentStudentNumber = rs.getInt("studentnumber");

                System.out.println("Student id:\t " + studentId);
                System.out.println("Student First Name:\t" + studentFirstName);
                System.out.println("Student Last Name:\t" + studentLastName);
                System.out.println("Student Grade:\t" + studentGrade);
                System.out.println("Student Number:\t" + studentStudentNumber);
                System.out.println("");
                System.out.println("");

            }

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //database configuration to check the admin
    boolean checkAdmin(String user, String pass) {
        boolean loggedIn = false;
        try {
            //uses prepared statement to select all the admins from adminlist table and check if any of them match with the user entries
            Statement stmt = adminCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM adminlist");
            rs.beforeFirst();
            while (rs.next()) {

                //checks if the username and passwordentries match with any of the information in the database
                if (user.equals(rs.getString("username")) && pass.equals(rs.getString("password"))) {
                    loggedIn = true;

                    break;

                } else {
                    loggedIn = false;

                }
            }

            //if entries are wrong.
            if (!loggedIn) {
                System.out.println("\n\nWrong Username or Password.");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);

        }

        //return logged in
        if (loggedIn) {
            return true;
        } else {
            return false;
        }
    }
    //database configuration to change the password
    void changePassword(String username, String newPass) {

        //database configuration to update the password for the Admin on database
        try {
            //uses prepared statement to update the password
            PreparedStatement stmt = adminCon().prepareStatement("UPDATE adminlist SET password = ? WHERE username = ?");
            stmt.setString(1, newPass);

            stmt.setString(2, username);

            stmt.executeUpdate();
            System.out.println("Succesfully Changed.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //database configuration to add admin
    void addAdmin(String newUsername, String newPass) {
        try {
            //inserts a new Admin using prepared statements
            PreparedStatement stmt = adminCon().prepareStatement("INSERT INTO adminList (username, password) VALUES (?, ?)");
            stmt.setString(1, newUsername);
            stmt.setString(2, newPass);
            stmt.execute();
            System.out.println("Succesfully Added.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //database configuration to get admin list
    void getAdminList() {
        String user;
        //configues the database connection to show all the available admins
        try {
            Statement stmt = adminCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM adminlist");
            while (rs.next()) {

                user = rs.getString("username");
                System.out.println("Username: " + user);
                System.out.println("");

            }
        } catch (ClassNotFoundException | SQLException ex) {
            //shows error if unsuccessful
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //database configuration to delete admin 
    void deleteAdmin(String user) {
        //configures the database connection to delete and Admin
        try {
            //deletes the Admin using prepared statement
            PreparedStatement stmt = adminCon().prepareStatement("DELETE FROM adminList WHERE username = ?");
                stmt.setString(1, user);
            stmt.execute();
            System.out.println("Succesfully deleted.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            //shows error if unsuccessful
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
