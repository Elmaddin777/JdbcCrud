package service;

import entity.EmployeeEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeService {
    boolean insertEmployee(EmployeeEntity empEntity);

    boolean updateEmployee(EmployeeEntity empEntity);

    ResultSet selectAllEmployees() throws SQLException;

    ResultSet selectEmployee(EmployeeEntity empEntity) throws SQLException;

    boolean deleteEmployee(EmployeeEntity employeeEntity);

    void closeConnection() throws SQLException;
}
