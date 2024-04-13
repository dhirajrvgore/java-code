package org.example.empStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeApp {
    public static void main(String[] args) {
        List<Employee> list = loadEmployeeList();


        System.out.println("\n 1: Case 1: filter employee having salalry > 25000====================");
        list.stream().filter(e->e.getSalary()>25000)
                .map(e->e.getFirstName()+" "+e.getLastName()).collect(Collectors.toList())
                .forEach(e-> System.out.println(e));

        System.out.println("\n 1: Case 2: filter employee having salalry > 25000===================");
        list.stream().filter(employee -> employee.getSalary()>25000)
                .map(Employee::getFirstName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\n 2: Group by type================================");
        Map<String, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(employee -> employee.getType()));
        System.out.println(collect);

        System.out.println("\n 3a :Sorting sallry in ascending order======================================");
         list.stream().map(Employee::getSalary).sorted()
                 .collect(Collectors.toList())
                         .forEach(System.out::println);


        System.out.println("\n 3b: 3rd Highest salary======================================");
         list.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder())
                .skip(2)
                .limit(1).collect(Collectors.toList())
                 .forEach(System.out::println);

    }




















    public static List<Employee> loadEmployeeList(){
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee(1L, "Dhiraj", "Gore", "dhiru@gmail.com", "male", "full time",25000d);
        Employee e2 = new Employee(2L, "Shubhangi", "Gore", "shubhangi@gmail.com", "female", "full time",50000d);
        Employee e3 = new Employee(3L, "Suresh", "Kale", "suresh@gmail.com", "male", "contract",70000d);
        Employee e4 = new Employee(4L, "Kunal", "Nade", "kunal@gmail.com", "male", "contract",99000d);
        Employee e5 = new Employee(5L, "Rajesh", "Shekhavat", "rajesh@gmail.com", "male", "full time",12000d);
        list.add(e1);
        list.add(e2);list.add(e3);list.add(e4);list.add(e5);

        return list;
    }
}
