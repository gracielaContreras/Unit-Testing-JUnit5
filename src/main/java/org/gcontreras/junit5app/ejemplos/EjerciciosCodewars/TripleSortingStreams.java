package org.gcontreras.junit5app.ejemplos.EjerciciosCodewars;

import org.gcontreras.junit5app.ejemplos.models.Student;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Triple Sorting - Sort & Stringify a list by 3 attributes
 * Tale University is a bit messy, and can't maintain an ordered list of their student.
 * Tale's dean wants to print a sortet list of his students by the gpa,
 * last name and age and post it on the walls so everybody can be impressed of his great students.
 *
 * Given a list of students, sort them by (from most important to least important):
 *
 * GPA (descending)
 * First letter of last name (ascending)
 * Age (ascending)
 * And the class Student:
 *
 * class Student {
 *     ...
 *   int getGpa()
 *   int getAge();
 *   String getFullName();
 * }
 * Return the sorted result as full names string, comma separated.
 *
 * For Example, given the list (name, age, gpa):
 *
 * David Goodman, 23, 88
 * Mark Rose, 25, 82
 * Jane Doe, 22, 90
 * Jane Dane, 25, 90
 * sort(students) should return "Jane Doe,Jane Dane,David Goodman,Mark Rose"
 */

public class TripleSortingStreams {

    public static void main(String[] args) {
        System.out.println(sort(getStudent()));
    }

    public static String sort(List<Student> students) {

        return students.stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed()
                        .thenComparing(s -> s.getFullName().split(" ")[1].charAt(0)))
                .map(Student::getFullName)
                .collect(Collectors.joining(","));

        // Otra forma de resolverlo
/*        List<String> collect = students.stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed()
                        .thenComparing(s -> s.getFullName().split(" ")[1].charAt(0)))
                .map(student -> student.getFullName())
                .collect(Collectors.toList());

        return collect.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));*/

//        Otra forma de eliminar los [..]
//        String str = collect.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");

    }
    public static List<Student> getStudent(){
        return List.of(
            new Student(23, 88, "David Goodman"),
            new Student(25, 82, "Mark Rose"),
            new Student(22, 90, "Jane Doe"),
            new Student(25, 90, "Jane Dane"));
    }
}
