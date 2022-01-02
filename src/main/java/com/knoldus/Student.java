package com.knoldus;

import java.util.Optional;

/**
 * The type Student.
 */
public class Student {
    private String name;
    private int rollNumber;
    private Optional<String> subject;

    /**
     * Instantiates a new Student.
     *
     * @param studentName       the student name
     * @param studentRollNumber the student roll number
     * @param studentSubject    the student subject
     */
    public Student(final String studentName, final int studentRollNumber,
            final Optional<String> studentSubject) {
        this.name = studentName;
        this.rollNumber = studentRollNumber;
        this.subject = studentSubject;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param studentName the student name
     */
    public void setName(final String studentName) {
        this.name = studentName;
    }

    /**
     * Gets roll number.
     *
     * @return the roll number
     */
    public int getRollNumber() {
        return rollNumber;
    }

    /**
     * Sets roll number.
     *
     * @param studentRollNumber the student roll number
     */
    public void setRollNumber(final int studentRollNumber) {
        this.rollNumber = studentRollNumber;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public Optional<String> getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param studentSubject the student subject
     */
    public void setSubject(final Optional<String> studentSubject) {
        this.subject = studentSubject;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", rollNumber=" + rollNumber
                + ", subject=" + subject
                + '}';
    }
}
