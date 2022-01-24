package sql;

public class EmployeeQuery {
    public static final String SQL_SELECT_ALL =
            "SELECT * FROM employees";
    public static final String SQL_SELECT =
            "SELECT * FROM employees WHERE last_name = ? AND first_name = ?";
    public static final String SQL_INSERT =
            "INSERT INTO employees (last_name, first_name, email, department, salary) VALUES (?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE =
            "UPDATE employees SET salary = ? WHERE last_name = ? AND first_name = ?";
    public static final String SQL_DELETE =
            "DELETE FROM employees WHERE last_name = ? AND first_name = ?";
}
