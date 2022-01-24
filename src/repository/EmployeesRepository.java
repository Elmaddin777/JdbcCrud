package repository;

import db.DbCredentials;
import entity.EmployeeEntity;
import java.io.IOException;
import java.sql.*;
import sql.EmployeeQuery;

public class EmployeesRepository {
    private final DbCredentials dbc;
    private Connection conn;
    private Statement stmt;
    private PreparedStatement preparedStmt;
    private ResultSet rs;

    public EmployeesRepository() throws IOException, SQLException {
        this.dbc = new DbCredentials();
        conn = DriverManager.getConnection(dbc.getDbUrl(), dbc.getUser(), dbc.getPasswrod());
        System.out.println("Database connection successful!\n");
    }

    public ResultSet selectAllEmployees() throws SQLException {
        System.out.println("-- Selecting employees from database\n");
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(EmployeeQuery.SQL_SELECT_ALL);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return rs;
    }

    public ResultSet selectEmployee(EmployeeEntity empEntity) throws SQLException {
        try {
            preparedStmt = conn.prepareStatement(EmployeeQuery.SQL_SELECT);
            preparedStmt.setString(1, empEntity.getLastName());
            preparedStmt.setString(2, empEntity.getFirstName());
            rs = preparedStmt.executeQuery();
            System.out.println("-- Current employee info\n\n( " + empEntity.getLastName() + ", " + empEntity.getFirstName()
                    + ", " + rs.getString("email") + ", "
                    + empEntity.getDepartment() + ", " + empEntity.getSalary() + " )\n");
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return rs;
    }

    public boolean deleteEmployee(EmployeeEntity empEntity){
        int row = 0;
        try {
            System.out.println("-- Deleting employee \n\n( " + empEntity.getLastName() + " " + empEntity.getFirstName() + " )\n");
            preparedStmt = conn.prepareStatement(EmployeeQuery.SQL_DELETE);
            preparedStmt.setString(1, empEntity.getLastName());
            preparedStmt.setString(2, empEntity.getFirstName());
            row = preparedStmt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        if (row > 0 ){
            System.out.println("-- Employee deleted\n");
            return true;
        }

        System.out.println("-- Employee delete error\n");
        return false;
    }

    public boolean updateEmployee(EmployeeEntity empEntity){
        int row = 0;
        try {
            System.out.println("-- Updating employee \n\n( " + empEntity.getLastName() + " " + empEntity.getFirstName() + " )\n");
            preparedStmt = conn.prepareStatement(EmployeeQuery.SQL_UPDATE);
            preparedStmt.setBigDecimal(1, empEntity.getSalary());
            preparedStmt.setString(2, empEntity.getLastName());
            preparedStmt.setString(3, empEntity.getFirstName());
            row = preparedStmt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        if (row > 0 ){
            System.out.println("-- Employee updated\n");
            return true;
        }

        System.out.println("-- Employee update error\n");
        return false;
    }

    public boolean insertEmployee(EmployeeEntity empEntity){
        int row = 0;
        try {
            System.out.println("-- Inserting a new employee to database\n");
            System.out.println("( " + empEntity.getLastName() + ", " + empEntity.getFirstName() + ", " + empEntity.getEmail() + ", "
                    + empEntity.getDepartment() + ", " + empEntity.getSalary() + " )\n");
            preparedStmt = conn.prepareStatement(EmployeeQuery.SQL_INSERT);
            preparedStmt.setString(1, empEntity.getLastName());
            preparedStmt.setString(2, empEntity.getFirstName());
            preparedStmt.setString(3, empEntity.getEmail());
            preparedStmt.setString(4, empEntity.getDepartment());
            preparedStmt.setBigDecimal(5, empEntity.getSalary());
            row = preparedStmt.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        if (row > 0 ){
            System.out.println("-- New employee added\n");
            return true;
        }

        System.out.println("-- New employee insert error\n");
        return false;
    }

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }

        if (stmt != null) {
            stmt.close();
        }

        if (conn != null) {
            conn.close();
        }

        System.out.println("\nDatabase connection closed!\n");
    }

}
