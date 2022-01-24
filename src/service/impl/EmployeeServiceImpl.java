package service.impl;

import entity.EmployeeEntity;
import service.EmployeeService;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import repository.EmployeesRepository;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeesRepository repo;

    public EmployeeServiceImpl() throws SQLException, IOException {
        repo = new EmployeesRepository();
    }

    @Override
    public boolean insertEmployee(EmployeeEntity empEntity){
        return repo.insertEmployee(empEntity);
    }

    @Override
    public boolean updateEmployee(EmployeeEntity empEntity){
        return repo.updateEmployee(empEntity);
    }

    @Override
    public ResultSet selectAllEmployees() throws SQLException {
        return repo.selectAllEmployees();
    }

    @Override
    public ResultSet selectEmployee(EmployeeEntity empEntity) throws SQLException {
        return repo.selectEmployee(empEntity);
    }

    @Override
    public boolean deleteEmployee(EmployeeEntity empEntity) {
        return repo.deleteEmployee(empEntity);
    }

    @Override
    public void closeConnection() throws SQLException {
        repo.closeConnection();
    }
}
