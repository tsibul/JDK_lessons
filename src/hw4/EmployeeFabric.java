package hw4;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeFabric {

    private ArrayList<Employee> employeeArrayList;

    public void addEmployee(Employee person) {
        employeeArrayList.add(person);
    }

    public ArrayList<Employee> expSearch(Integer exp) {
        return (ArrayList<Employee>) employeeArrayList.stream().filter(el -> el.getExperience() == exp).collect(Collectors.toList());
    }

    public ArrayList<Employee> phoneSearch(String phone) {
        return (ArrayList<Employee>) employeeArrayList.stream().filter(el ->
                el.getPhoneNo().equals(phone)).collect(Collectors.toList());
    }

    public Employee personNoSearch(Integer personNo) {
        for (Employee emp : employeeArrayList) {
            if (emp.getPersonNo() == personNo) {
                return emp;
            }
        }
        return null;
    }
}
