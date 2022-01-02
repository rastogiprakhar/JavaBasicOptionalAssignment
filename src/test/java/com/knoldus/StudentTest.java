package com.knoldus;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * The type Student test.
 */
public class StudentTest extends TestCase {

    /**
     * The Student.
     */
    Student student;

    @Override
    @Before
    public void setUp() throws Exception {
        student = new Student("Prakhar",1, Optional.of("Java"));
    }

    /**
     * Test get name.
     */
    @Test
    public void testGetName() {
        String expectedName = "Prakhar";
        String actualName = student.getName();
        assertEquals(expectedName, actualName);
    }

    /**
     * Test set name.
     */
    @Test
    public void testSetName() {
        String expectedName = "Rahul";
        student.setName("Rahul");
        String actualName = student.getName();
        assertTrue(expectedName.equals(actualName));
    }

    /**
     * Test get roll number.
     */
    @Test
    public void testGetRollNumber() {
        int expectedRollNo = 1;
        int actualRollNo = student.getRollNumber();
        assertEquals(expectedRollNo, actualRollNo);
    }

    /**
     * Test set roll number.
     */
    @Test
    public void testSetRollNumber() {
        student.setRollNumber(2);
        int expectedRollNo = 2;
        int actualRollNo = student.getRollNumber();
        assertEquals(expectedRollNo, actualRollNo);
    }

    /**
     * Test get subject.
     */
    public void testGetSubject() {
        Optional<String> expectedSubject = Optional.of("Java");
        Optional<String> actualSubject = student.getSubject();
        assertEquals(expectedSubject,actualSubject);
    }

    /**
     * Test set subject.
     */
    @Test
    public void testSetSubject() {
        student.setSubject(Optional.of("Python"));
        Optional<String> expectedSubject = Optional.of("Python");
        Optional<String> actualSubject = student.getSubject();
        assertEquals(expectedSubject,actualSubject);
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String expected = "Student{" +
                "name='" + student.getName() + '\'' +
                ", rollNumber=" + student.getRollNumber() +
                ", subject=" + student.getSubject() +
                '}';
        String actual = student.toString();
        assertEquals(expected,actual);
    }
}
