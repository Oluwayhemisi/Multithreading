package contact;

import java.sql.*;
import java.util.Scanner;

public class Contact {
    static final String DB_URL = "jdbc:sqlserver://ISW-220721-790\\SQLEXPRESS01;" +
            "encrypt=false;integratedSecurity=true;";

    static String CONTACT_QUERY = "SELECT Contact_id, First_Name, Last_Name, Phone_Number, Sex, DOB FROM Contact";


    public static void insertRecordsIntoContact(String databaseName) {
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
             Statement stmt = con.createStatement();
        ) {
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Contact VALUES ('Halima', 'Ismail','09075586677','Female', '1995-09-09')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Contact VALUES ('Tiara','Oluwafemi','08073665456216','Female', '2021-01-21')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Contact VALUES ('Nayla','Bello','0702637463738','Female', '2022-10-17')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Contact VALUES ('Ivan','Ololade','09026273634','Male','2022-01-16')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRecordsIntoReference(String databaseName) {
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
             Statement stmt = con.createStatement();
        ) {
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Reference VALUES ('Bolaji Ismail', 'Engineer','09075586677', 1, 17)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Reference VALUES ('GabrielOluwafemi','Contact Manager','080736654566',28, 5)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Reference VALUES ('SegunBello','ProjectManager','0702637463738', 37, 9)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Reference VALUES ('Fisayo Ololade','Product Designer','09026273634',46, 13)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Reference VALUES ('EnitanOluwafemi','Customer Representative','080736654566',28, 5)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRecordsIntoAddress(String databaseName) {
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
             Statement stmt = con.createStatement();
        ) {
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Address_ VALUES ('Emily Akinola', 'Lagos','Lagos', 'Nigeria', 100001)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Address_ VALUES ('Enahora Estate Ogba','Lagos','Lagos','Nigeria', 110008)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Address_ VALUES ('Yetunde Brown Gbagada','Lagos','Lagos', 'Nigeria', 11111)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Address_ VALUES ('Ikorodu','Lagos','Lagos','Nigeria', 122111)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Address_ VALUES ('Ogudu', 'Lagos','Lagos', 'Nigeria', 101201)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertRecordsIntoContactAdd(String databaseName) {
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
             Statement stmt = con.createStatement();
        ) {
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Contact_Add VALUES (1,9)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Contact_Add VALUES (19,13)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Contact_Add VALUES (28,17)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Contact_Add VALUES (37,21)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Contact_Add VALUES (19,9)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectAllContact(String databaseName) {
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(CONTACT_QUERY);
        ) {
            while(rs.next()) {
                System.out.print("FirstName: " + rs.getString("First_Name"));
                System.out.print(", LastName: " + rs.getString("Last_Name"));
                System.out.print(", PhoneNumber: " + rs.getString("Phone_Number"));
                System.out.println(", Sex: " + rs.getString("Sex"));
                    System.out.println(", DOB: " + rs.getDate("DOB"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectContactById(String databaseName) {
        Scanner scanner = new Scanner(System.in);
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");

        ) {
            System.out.println("Enter an Id");
            int id = scanner.nextInt();
            String SELECT_CONTACT_BY_ID = "SELECT First_Name, Last_Name, Phone_Number, Sex, DOB FROM Contact WHERE Contact_id= "+ id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_CONTACT_BY_ID);
            while(rs.next()) {
                System.out.print("FisrtName: " + rs.getString("First_Name"));
                System.out.print(", LastName: " + rs.getString("Last_Name"));
                System.out.print(", PhoneNumber: " + rs.getString("Phone_Number"));
                System.out.println(", Sex: " + rs.getString("Sex"));
                System.out.println(", DOB: " + rs.getDate("DOB"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void selectReferenceByContactId(String databaseName) {
        Scanner scanner = new Scanner(System.in);
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");

        ) {
            System.out.println("Enter an Id");
            int id = scanner.nextInt();
            String SELECT_REFERENCE_BY_CONTACT_ID = "SELECT Ref_Name, Profession, Phone_Number, Contact_id, Add_id FROM Reference WHERE Contact_id= "+ id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_REFERENCE_BY_CONTACT_ID);
            while(rs.next()) {
                System.out.print("Ref_Name: " + rs.getString("Ref_Name"));
                System.out.print(", Profession: " + rs.getString("Profession"));
                System.out.print(", PhoneNumber: " + rs.getString("Phone_Number"));
                System.out.println(", Contact_id: " + rs.getInt("Contact_id"));
                System.out.println(", Address_id: " + rs.getInt("Add_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void selectAddressById(String databaseName) {
        Scanner scanner = new Scanner(System.in);
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");

        ) {
            System.out.println("Enter Address Id");
            int id = scanner.nextInt();
            String SELECT_ADDRESS_BY_REFERENCE_ID = "SELECT Add_id, Street, City, Add_State, Country, Zipcode FROM Address_ WHERE Add_id = "+id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ADDRESS_BY_REFERENCE_ID);
            while(rs.next()) {
                System.out.println(", Address_id: " + rs.getInt("Add_id"));
                System.out.print("Street: " + rs.getString("Street"));
                System.out.print(", City: " + rs.getString("City"));
                System.out.print(", Add_State: " + rs.getString("Add_State"));
                System.out.println(", Country: " + rs.getString("Country"));
                System.out.println(", Zipcode: " + rs.getInt("Zipcode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateContact(String databaseName) {
        try (Connection con = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
             Statement stmt = con.createStatement();
        ) {
            String sql = "UPDATE Contact SET First_Name='Yemisi' WHERE Contact_id=19";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(CONTACT_QUERY);
            while (rs.next()) {
                System.out.print("Contact_id: " + rs.getInt("Contact_id"));
                System.out.print(", First_Name: " + rs.getString("First_Name"));
                System.out.print(", Last_Name: " + rs.getString("Last_Name"));
                System.out.println(", Phone_Number: " + rs.getString("Phone_Number"));
                System.out.println(", Sex: " + rs.getString("Sex"));
                System.out.println(", DOB: " + rs.getDate("DOB"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        insertRecordsIntoContact("Training");
//        insertRecordsIntoReference("Training");
//        insertRecordsIntoAddress("Training");
//        insertRecordsIntoContactAdd("Training");
//        selectAllContact("Training");
//        selectContactById("Training");
//        selectReferenceByContactId("Training");
//        selectAddressById("Training");
        updateContact("Training");

    }



}
