package model;

import java.sql.*;

/**
 * Student database access object.
 *
 */

public class StudentDAO extends BaseDAO {

    public StudentDAO(){
        System.out.println("StudentDAO Instantiated");
    }

    /**
     * Create table if it does not exist.
     */
    public void createIfNone(){

        boolean createTable = false;
        final String DATABASE_NAME = "my_students";
        final String CREATE_TABLE = "create table csc3610_students ";
        final String ID = "(id integer not null auto_increment, ";
        final String STUDENTID = "studentID varchar(255), ";
        final String FIRSTNAME = "fname varchar(255), ";
        final String LASTNAME = "lname varchar(255), ";
        final String PRIMARY_KEY =  "primary key (id))";

        try (Connection connection = this.getConnection()) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println("Checking metaData for table.");
            System.out.print("\n\n");

            //Find a list of all table contained on the MySQL database server using catalogs
            ResultSet resultSet = databaseMetaData.getCatalogs();
            System.out.println("Result Set returned.");
            System.out.println("Looping through Result Set.");
            System.out.print("\n\n");

            //Search for the name of table
            while(resultSet.next()){
                String catalogs = resultSet.getString(1);
                if(DATABASE_NAME.equals(catalogs)) {
                    System.out.print("\nDatabase exists.\n");
                    createTable = false;
                }else{
                    System.out.print("\nNo table of that name.\n");
                    createTable = true;
                    System.out.print("Variable createTable set: true");
                }
            }

            System.out.print("\n\n");
            if(createTable){
                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE + ID + STUDENTID + FIRSTNAME + LASTNAME + PRIMARY_KEY);
                preparedStatement.execute();
                System.out.print("\nPrepared Statement executed..");
                System.out.print("\nCreated new table.\n");
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }

    /**
     * Add a new student to the database.
     * @param studentName String of studentID, fname, lname.
     */
    public void addNewStudent(String studentID, String fname, String lname) {
        
        try (Connection connection = this.getConnection()) {
  
        	PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO csc3610_students(studentID, fname, lname)" +
        						" VALUES ('" + studentID +"', '"+ fname +"','"+ lname +"' )");
        	preparedStatement.execute();
            System.out.print("\nConnected to database!\nNew student was added successfully\n");
           // lblDisplay.setText();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
}
