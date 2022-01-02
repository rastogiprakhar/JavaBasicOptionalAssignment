package com.knoldus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Class room.
 */
public class ClassRoom {
    private String roomId;
    private Optional<List<Student>> studentList;

    /**
     * Instantiates a new Class room.
     *
     * @param classRoomId   the class room id
     * @param classStudents the class students
     */
    public ClassRoom(final String classRoomId,
            final Optional<List<Student>> classStudents) {
        this.roomId = classRoomId;
        this.studentList = classStudents;
    }

    /**
     * Gets students without subject.
     *
     * @return the students without subject
     */
    public List<Student> getStudentsWithoutSubject() {
        List<Student> withoutSubject =  studentList.get().stream()
                .filter(student -> student
                        .getSubject().equals(Optional.empty()))
                .collect(Collectors.toList());
        return withoutSubject;
    }

    /**
     * Gets distinct subjects by room id.
     *
     * @param classRoomId the class room id
     * @return the distinct subjects by room id
     */
    public List<Optional<String>> getDistinctSubjectsByRoomId(
            final String classRoomId) {
        if (!classRoomId.equals(roomId)) {
            return null;
        }
        List<Optional<String>> distinctSubject = studentList.get()
                .stream()
                .filter(student -> student.getSubject().isPresent())
                .map(student -> student.getSubject()).distinct()
                .collect(Collectors.toList());
        return distinctSubject;
    }

    /**
     * Has students string.
     *
     * @return the string
     */
    public String hasStudents() {
        if (studentList.isPresent()) {
            return "Hello Students";
        }
        return "";
    }

    /**
     * Gets room id.
     *
     * @return the room id
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * Sets room id.
     *
     * @param classRoomId the class room id
     */
    public void setRoomId(final String classRoomId) {
        this.roomId = classRoomId;
    }

    /**
     * Gets student list.
     *
     * @return the student list
     */
    public Optional<List<Student>> getStudentList() {
        return studentList;
    }

    /**
     * Sets student list.
     *
     * @param classStudentList the class student list
     */
    public void setStudentList(final Optional<List<Student>> classStudentList) {
        this.studentList = classStudentList;
    }
    @Override
    public String toString() {
        return "ClassRoom{"
                + "roomId='" + roomId + '\''
                + ", studentList=" + studentList
                + '}';
    }
}

