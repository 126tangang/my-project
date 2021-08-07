package exercise.demo4.team.junit;

import exercise.demo4.team.domain.Employee;
import exercise.demo4.team.service.NameListService;
import exercise.demo4.team.service.TeamException;
import org.junit.Test;

/**
 * 对NameListService类的测试
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int index = 0; index < employees.length; index++) {
            System.out.println(employees[index]);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService nameListService = new NameListService();

        try {
            Employee employee = nameListService.getEmployee(100);
            System.out.println(employee);
        } catch (TeamException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
