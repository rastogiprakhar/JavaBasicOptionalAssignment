package com.knoldus;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Class room test.
 */
public class ClassRoomTest extends TestCase {

    /**
     * The Student list 1.
     */
    List<Student> studentList1, /**
     * The Student list 2.
     */
    studentList2;
    /**
     * The Class room 1.
     */
    ClassRoom classRoom1, /**
     * The Class room 2.
     */
    classRoom2;

    @Override
    @Before
    public void setUp() throws Exception {
        Student student1 = new Student("Prakhar", 1, Optional.of("Java"));
        Student student2 = new Student("Ajay", 2, Optional.empty());
        Student student3 = new Student("Rahul", 3, Optional.empty());
        Student student4 = new Student("Rohit", 4, Optional.of("Python"));

        Student student5 = new Student("Shubham", 5, Optional.of("PHP"));
        Student student6 = new Student("Sajal", 6, Optional.of("Java"));
        Student student7 = new Student("Gulshan", 7, Optional.of("Python"));
        Student student10 = new Student("Prakhar", 10, Optional.of("Python"));
        Student student11 = new Student("Akshay", 11, Optional.of("Java"));

        studentList1 = Arrays.asList(student1, student2, student3, student4);
        studentList2 = Arrays.asList(student5, student6, student7, student10,student11);

        classRoom1 = new ClassRoom("abc", Optional.of(studentList1));
        classRoom2 = new ClassRoom("xyz", Optional.of(studentList2));

    }

    /**
     * Test get students without subject correct if return list.
     */
    @Test
    public void testGetStudentsWithoutSubject_CorrectIfReturnList() {
        List<Student> expectedStudents = Arrays.asList(new Student("Ajay", 2, Optional.empty()),
                new Student("Rahul", 3, Optional.empty()));
        List<Student> actualStudents = classRoom1.getStudentsWithoutSubject();
        assertTrue(actualStudents.size() > 1);
        assertEquals(expectedStudents.get(0).getRollNumber(),actualStudents.get(0).getRollNumber());
    }

    /**
     * Test get distinct subjects by room id correct if subjects found by room id.
     */
    @Test
    public void testGetDistinctSubjectsByRoomId_CorrectIfSubjectsFoundByRoomId() {
        List<Optional<String>> expectedSubjects = Arrays.asList(Optional.of("PHP"), Optional.of("Java"), Optional.of("Python"));
        List<Optional<String>> actualSubjects = classRoom2.getDistinctSubjectsByRoomId("xyz");
        assertTrue(actualSubjects.size() > 1);
        assertEquals(expectedSubjects,actualSubjects);
    }

    /**
     * Test get distinct subjects by room id return null if subjects not found by room id.
     */
    @Test
    public void testGetDistinctSubjectsByRoomId_ReturnNullIfSubjectsNotFoundByRoomId() {
        List<Optional<String>> actualSubjects = classRoom2.getDistinctSubjectsByRoomId("ba01");
        assertEquals(null,actualSubjects);
    }

    /**
     * Test has students return string message if have students.
     */
    @Test
    public void testHasStudents_ReturnStringMessageIfHaveStudents() {
        String expectedResult = "Hello Students";
        String actualResutl = classRoom1.hasStudents();
        assertTrue(expectedResult.equals(actualResutl));
    }

    /**
     * Test has students return empty string if not have students.
     */
    @Test
    public void testHasStudents_ReturnEmptyStringIfNotHaveStudents() {
        String expectedResult = "";
        classRoom1.setStudentList(Optional.empty());
        String actualResult = classRoom1.hasStudents();
        assertTrue(expectedResult.equals(actualResult));
    }

    /**
     * Test get room id correct if return room id.
     */
    @Test
    public void testGetRoomId_CorrectIfReturnRoomId(){
        String expectedRoomId = "abc";
        String actualRoomId = classRoom1.getRoomId();
        assertEquals(expectedRoomId,actualRoomId);
    }

    /**
     * Test set room id correct if set room id.
     */
    @Test
    public void testSetRoomId_CorrectIfSetRoomId(){
        classRoom1.setRoomId("MCA01");
        String expectedRoomId = "MCA01";
        String actualRoomId = classRoom1.getRoomId();
        assertEquals(expectedRoomId,actualRoomId);
    }

    /**
     * Testget student list correct if return students list.
     */
    @Test
    public void testgetStudentList_CorrectIfReturnStudentsList(){
        Optional<List<Student>> actualList = classRoom1.getStudentList();
        assertTrue(actualList.get().size()>2);
    }

    /**
     * Testset student list correct if set students list.
     */
    @Test
    public void testsetStudentList_CorrectIfSetStudentsList(){
        classRoom1.setStudentList(Optional.ofNullable(studentList2));
        Optional<List<Student>> expectedList = Optional.ofNullable(studentList2);
        Optional<List<Student>> actualList = classRoom1.getStudentList();
        assertTrue(actualList.get().size()>2);
        assertEquals( expectedList.get().get(0).getRollNumber(), actualList.get().get(0).getRollNumber());
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String expected = "ClassRoom{" +
                "roomId='" + classRoom1.getRoomId() + '\'' +
                ", studentList=" + classRoom1.getStudentList() +
                '}';
        String actual = classRoom1.toString();
        assertEquals(expected,actual);
    }
}
