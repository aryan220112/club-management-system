# club-management-system
club management system - ClubHub
A club management system that manages all the club related activities in a college. Some of the functionalities are as follows :

1.Admin related operations (inserting a club, deleting a club, deleting a member, updating a club)

2.Student related activities ( getting a club list, enrolling in a club)

3.Other functionalities include : changing admin password, adding new admins, deleting existing admins.

--------------------------------------------------------
USAGE :

-On the admin side, an admin can change password, add an admin, see the list of admins and delete an admin by going through the required verification steps. An admin also has the authority to manage the clubs by adding new clubs, editing their information, adding/deleting posts to the clubs’ newsletter, and see the list of club members, adding members and deleting them.

-On the client side, students can see the full list of available clubs in their school, they can check out the club newsletters and posts as well as joining a club if they want to do so.

--------------------------------------------------------
DESIGN :

1- Main Classes:

-clubHub class is the main class as it is only meant to ask the user if they are the admin or a student.

-StudentEngine class handles the GET and POST requests to view, add, update, or delete students to clubs.

-adminEngine class handles the GET and POST requests to view, add, update, or delete admins as well as clubs.

2- Sub Classes:

-Club class is consisted of functions which call upon the dataBaseCon class in order to handle operations related to viewing, adding, updating and deleting clubs.

-Admin class is consisted of functions which call upon the dataBaseCon class in order to handle operations related to viewing, adding, updating and deleting admins.

-Student class is consisted of functions which call upon the dataBaseCon class in order to handle operations related to viewing, adding, updating and deleting students.

-DataBaseCon class consisted of functions which directly process the operations related to viewing, adding, updating and deleting in the MYSQL database.
