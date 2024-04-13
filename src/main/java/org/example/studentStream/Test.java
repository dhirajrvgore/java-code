package org.example.studentStream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static List<Student> list = StudentUtils.loadStudent();
    public static void main(String[] args) {

        System.out.println("1- Find list of students whose first name starts with alphabet A");
        list.stream().filter(s->s.getFirstName().startsWith("A")).collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\n2- Group The Student By Department Names");
        Map<String, List<Student>> groupByDept = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName));
        groupByDept.forEach((k,v)-> {
            System.out.println("Key -"+k);
            System.out.println("value-"+v);
        });

        System.out.println("\n3- Find the total count of student using stream");
        long count = list.stream().count();
        System.out.println("Total Student Count -"+count);

        System.out.println("\n4- Find the max age of student");
        int maxAge = list.stream().mapToInt(Student::getAge).max().getAsInt();
        System.out.println("Max age of Student : "+maxAge);

        System.out.println("\n5- Find all departments names");
        list.stream().map(Student::getDepartmantName).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\n6- Find the count of student in each department");
        Map<String, Long> deptWiseStuCount = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        deptWiseStuCount.forEach((k,v)-> System.out.println("Dept-"+k+", Count-"+v+"\n"));

        System.out.println("\n7- Find the list of students whose age is less than 30");
        list.stream().filter(s->s.getAge()<30)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\n8- Find the list of students whose rank is in between 50 and 100");
        list.stream().filter(s->s.getRank()>50 && s.getRank()<100)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\n9- Find the average age of male and female students");
        Map<String, Double> avgAgeByGender = list.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        avgAgeByGender.forEach((k,v)-> System.out.println("Gnnder-"+k+" avg Age-"+v));

        System.out.println("\n10- Find the department who is having maximum number of students");
        Map.Entry<String, Long> maxStudentDept = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println("Dept having max number of Students -"+maxStudentDept.getKey());


        System.out.println("\n11- Find the Students who stays in Delhi and sort them by their first names");
        list.stream().filter(s->s.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName))
                        .collect(Collectors.toList())
                            .forEach(System.out::println);



        System.out.println("\n12- Find the average rank in all departments");
        Map<String, Double> collect = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
        collect.forEach((k,v)-> System.out.println("Dept-"+k+", avg-"+v));

        System.out.println("\n13- Find the highest rank in each department");
        System.out.println("\n14- Find the list of students and sort them by their rank");
        System.out.println("\n15- Find the student who has second rank");


    }
}
