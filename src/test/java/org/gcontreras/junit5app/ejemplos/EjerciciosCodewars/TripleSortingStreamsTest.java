package org.gcontreras.junit5app.ejemplos.EjerciciosCodewars;

import org.gcontreras.junit5app.ejemplos.models.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripleSortingStreamsTest {

    @Test
    public void basicTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, 88, "David Goodman"));
        students.add(new Student(25, 82, "Mark Rose"));
        students.add(new Student(22, 90, "Jane Doe"));
        students.add(new Student(25, 90, "Jane Dane"));
        assertEquals("Jane Doe,Jane Dane,David Goodman,Mark Rose",
                TripleSortingStreams.sort(students));
    }
}