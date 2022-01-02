package com.knoldus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Application main.
 */
class ApplicationMain {
    /**
     * main() method for the application.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        final int student1RollNo = 1;
        final int student2RollNo = 2;
        final int student3RollNo = 3;
        final int student4RollNo = 4;
        final int student5RollNo = 5;
        final int student6RollNo = 6;
        final int student7RollNo = 7;
        final int student8RollNo = 8;
        final int student9RollNo = 9;
        final int student10RollNo = 10;

        Student student1 = new Student("Prakhar", student1RollNo, Optional.of("Java"));
        Student student2 = new Student("Sajal", student2RollNo, Optional.empty());
        Student student3 = new Student("Ajay", student3RollNo, Optional.empty());
        Student student4 = new Student("Rahul", student4RollNo, Optional.of("Spring"));
        Student student5 = new Student("Rohit", student5RollNo, Optional.of("PHP"));
        Student student6 = new Student("Mayank", student6RollNo, Optional.of("React"));
        Student student7 = new Student("Shubham", student7RollNo, Optional.of("Angular"));
        Student student8 = new Student("Prince", student8RollNo, Optional.of("Python"));
        Student student9 = new Student("Gulshan", student9RollNo, Optional.of("Angular"));
        Student student10 = new Student("Atul", student10RollNo, Optional.of("Spring"));

        Optional<List<Student>> studentList = Optional
                .of(Arrays.asList(student1, student2, student3, student1));

        Optional<List<Student>> studentList2 = Optional
                .of(Arrays.asList(student4, student5, student6,
                        student7, student9, student10, student8));

        List<ClassRoom> classRooms = new ArrayList<>();
        classRooms.add(new ClassRoom("BCA01", studentList));
        classRooms.add(new ClassRoom("xyz", studentList2));
        classRooms.add(new ClassRoom("MCA01", Optional.empty()));
         String resultString = classRooms.get(1).hasStudents();
        System.out.println(resultString);
         List<Student> studentsWithoutSubject = classRooms
                .get(0).getStudentsWithoutSubject();
        System.out.println("\nStudent List Without subject: ");
        studentsWithoutSubject.stream().forEach(System.out::println);
//      * Finding distinct subjects of
//      students associated with room id "xyz".
        List<Optional<String>> subjectsList = classRooms.get(1)
                .getDistinctSubjectsByRoomId("xyz");
        System.out.println("\nDistinct Subject List of ClassRoom xyz: ");
        subjectsList.stream().forEach(System.out::println);
    }
}
