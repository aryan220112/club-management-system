package clubhub;

public class Club {
    
    //decalres the variables for Club class
    private static int clubId;
    private static String clubName;
    private static int clubSize;
    private static String clubManager;
    private static String clubLocation;


    DataBaseCon db = new DataBaseCon();
    
    //method to add a Club 
    public void addClub(String name, int size, String manager, String location) {

        clubName = name;
        clubSize = size;
        clubManager = manager;
        clubLocation = location;
        
        //calls the db object to insert a new Club
        db.insertData(clubName, clubSize, clubManager, clubLocation);

    }
    
    //method to get the list of all the current clubs
    public void getClubData() {
         System.out.println("Here is the list of current clubs:\n");
        //calls the db object to get the Club list
        db.getData();
    }
    
    //method to change the name of a Club
    public String changeName(int currentId, String newName) {

        clubName = newName;
        //calls the db object to update the Club name
        db.updateDataName(currentId, newName);
        return clubName;

    }
    
    //method to change the size of the Club
    public int changeSize(int currentId, int newSize) {

        clubSize = newSize;
        //calls the db object to change the size of a Club
        db.updateDataSize(currentId, newSize);
        return clubSize;

    }
    
    //method to change the name of the manager of a Club
    public String changeManager(int currentId, String newManager) {

        clubManager = newManager;
        //calls the db object to change the name of manager
        db.updateDataManager(currentId, newManager);
        return clubManager;

    }
    //method to change the name of the location of a Club
    public String changeLocation(int currentId, String newLocation) {

        clubLocation = newLocation;
        //calls the db object to change the location 
        db.updateDataLocation(currentId, newLocation);
        return clubLocation;

    }
    
    //method to delete a Club
    public void deleteClub(int id) {

        clubId = id;
        //calls db to delete table for each Club
        db.deleteClub(id);

    }
    
    //method to create a seperate table for each Club in order to keep the records of their members
    public void createClubTable(String name) {

        clubName = name;
        //calls db to create a member table for each Club
        db.createTable(clubName);

    }
    
    
    //method to delete the Club table both member and post tables
    public void deleteClubTable(String name) {

        clubName = name;
        //calls db to delete tables for each Club 
        db.deleteTable(clubName);

    }
    
    //method to increae the size of a Club when a member gets added
    public void memberAdded(int id) {

        clubId = id;
        //calls db object to update and increase the size of a Club
        db.memberIncreased(clubId);

    }
    
    public void memberRemoved(int id) {

        clubId = id;
        //calls db object to update and increase the size of a Club
        db.memberDecreased(clubId);

    }
    
    //method to get the list of members for a specific Club
    public void memberList(String cName) {
        System.out.println("Here is the list of members:\n\n");
        clubName = cName;
        //calls db object to add a new member
        db.getMemberList(clubName);
    }
    
    
}
