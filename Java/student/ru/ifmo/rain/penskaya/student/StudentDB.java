package ru.ifmo.rain.penskaya.student;

import info.kgeorgiy.java.advanced.student.Student;
import info.kgeorgiy.java.advanced.student.StudentQuery;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentDB implements StudentQuery {

    private final Comparator<Student> name = Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName).thenComparingInt(Student::getId);

    private List<String> mappedStudent(List<Student> students, Function<Student,String> map){
        return students.stream().map(map).collect(Collectors.toList());
    }

    private List<Student> sortedStudent(Collection<Student> students, Comparator<Student> comparator){
        return students.stream().sorted(comparator).collect(Collectors.toList());
    }

    private List<Student> filteredStudent(Collection<Student> students, Comparator<Student> comparator, Predicate<Student> predicate){
        return students.stream().filter(predicate).sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public List<String> getFirstNames(List<Student> list) {
        return mappedStudent(list, Student::getFirstName);
    }

    @Override
    public List<String> getLastNames(List<Student> list) {
        return mappedStudent(list, Student::getLastName);
    }

    @Override
    public List<String> getGroups(List<Student> list) {
        return mappedStudent(list, Student::getGroup);
    }

    @Override
    public List<String> getFullNames(List<Student> list) {
        return mappedStudent(list, s -> String.format("%s %s", s.getFirstName(), s.getLastName()));
    }

    @Override
    public Set<String> getDistinctFirstNames(List<Student> list) {
        return new TreeSet<>(getFirstNames(list));
    }

    @Override
    public String getMinStudentFirstName(List<Student> list) {
        return list.stream().min(Student::compareTo).map(Student::getFirstName).orElse("");
    }

    @Override
    public List<Student> sortStudentsById(Collection<Student> collection) {
        return sortedStudent(collection, Student::compareTo);
    }

    @Override
    public List<Student> sortStudentsByName(Collection<Student> collection) {
        return sortedStudent(collection, name);
    }

    @Override
    public List<Student> findStudentsByFirstName(Collection<Student> collection, String s) {
        return filteredStudent(collection, name, student -> student.getFirstName().equals(s));
    }

    @Override
    public List<Student> findStudentsByLastName(Collection<Student> collection, String s) {
        return filteredStudent(collection, name, student -> student.getLastName().equals(s));
    }

    @Override
    public List<Student> findStudentsByGroup(Collection<Student> collection, String s) {
        return filteredStudent(collection, name, student -> student.getGroup().equals(s));
    }

    @Override
    public Map<String, String> findStudentNamesByGroup(Collection<Student> collection, String s) {
        return collection.stream().filter(student -> student.getGroup().equals(s)).collect(Collectors.toMap(Student::getLastName, Student::getFirstName, BinaryOperator.minBy(String::compareTo)));
    }
}


//java -cp . -p . -m info.kgeorgiy.java.advanced.student StudentQuery ru.ifmo.rain.penskaya.student.StudentDB