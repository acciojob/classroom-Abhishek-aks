package com.driver;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student > hmstudent = new HashMap<>();
    HashMap<String, Teacher > hmteacher = new HashMap<>();
    HashMap<String, List<String>> hmpair = new HashMap<String, List<String>>();


    public void addStudent(Student student) {
        hmstudent.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        hmteacher.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName) {
        List<String> studentList = new ArrayList<>();
        if (hmpair.containsKey(teacherName)){
            studentList.add(studentName);
            hmpair.put(teacherName,studentList);
        }
        else{
            studentList.add(studentName);
            hmpair.put(teacherName,studentList);
        }
    }


    public Student getStudentByName(String name) {
        for (String studentname: hmstudent.keySet()){
            if(studentname.equals(studentname)){
                return hmstudent.get(studentname);
            }
        }
        return null;
    }

    public Teacher getTeacherByName(String name) {
        for(String teachername: hmteacher.keySet()){
            if(teachername.equals(name)) {
                return hmteacher.get(name);
            }
        } return null;
    }

//    public List<String> getStudentsByTeacherName(String name) {
//        List<String> studentList = new ArrayList<>();
//        if(hmpair.containsKey(hmteacher.get(name))) {
//            studentList = hmpair.get(hmteacher.get(name));
//        }
//        return studentList;
//    }


    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        for(String stud: hmstudent.keySet()){
            students.add(stud);
        }
        return students;
    }


    public Teacher deleteTeacherByName(String name) {
        Teacher teacher = hmteacher.get(name);
        hmteacher.remove(name);
        String tname;
        for(Student student: hmpair.get(teacher)) {
            hmstudent.remove(student.getName());

        }
        tname = hmpair.remove(teacher);
        return tname;

        }

    public void AllTeachers() {
        for(Teacher teacher: hmteacher.values())
        {
        for(Student student: hmpair.get(teacher))
        {
        hmstudent.remove(student.getName());
        }
        }
        hmpair.clear();
        hmteacher.clear();

        }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> studentList = new ArrayList<>();
        if(hmpair.containsKey(hmteacher.get(teacher))) {
            studentList = hmpair.get(hmteacher.get(teacher));
        }
        return studentList;
    }

}
