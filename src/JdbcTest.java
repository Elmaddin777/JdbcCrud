import entity.EmployeeEntity;
import service.impl.EmployeeServiceImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) throws SQLException, IOException {

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        // Insert employee
        employeeService.insertEmployee(
                new EmployeeEntity( "Wright", "Eric", "eric.wright@foo.com", "HR", new BigDecimal(30000))
        );

        // Update employee
        employeeService.updateEmployee(
                new EmployeeEntity("Wright", "Eric",  new BigDecimal(40000))
        );

        // Delete employee
        employeeService.deleteEmployee(
          new EmployeeEntity("Wright", "Eric")
        );

        // Select employees
        ResultSet result = employeeService.selectAllEmployees();
        while(result.next()){
            System.out.println(result.getString("last_name") + ", "
                    + result.getString("first_name") + ", "
                    + result.getString("salary")
            );
        }
        employeeService.closeConnection();
    }
}
