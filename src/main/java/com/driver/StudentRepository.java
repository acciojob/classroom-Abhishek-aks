package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
//    HashMap<String, Student> studentHashMap = new HashMap<>();
//    HashMap<String, Teacher> teacherHashMap = new HashMap<>();
//    HashMap<String, List<String>> studentTeacherHashMap = new HashMap<>();
//
//    public void addStudent(Student student) {
//        studentHashMap.put(student.getName(), student);
//    }
//
//    public void addTeacher(Teacher teacher) {
//        teacherHashMap.put(teacher.getName(), teacher);
//    }
//
//    public void addStudentTeacherPair(String studentName, String teacherName) {
//        if (studentTeacherHashMap.containsKey(teacherName)) {
//            studentTeacherHashMap.get(teacherName).add(studentName);
//        } else {
//            List<String> l = new ArrayList<>();
//            l.add(studentName);
//            studentTeacherHashMap.put(teacherName, l);
//        }
//    }
//
//    public Student getStudentByName(String studentName) {
//        return studentHashMap.get(studentName);
//    }
//
//    public Teacher getTeacherByName(String teacherName) {
//        return teacherHashMap.get(teacherName);
//    }
//
//    public List<String> getStudentsByTeacherName(String teacherName) {
//        return studentTeacherHashMap.get(teacherName);
//    }
//
//    public List<String> getAllStudents() {
//        return new ArrayList<>(studentHashMap.keySet());
//    }
//
//    public void deleteTeacherByName(String teacherName) {
//        List<String> l = new ArrayList<>(studentTeacherHashMap.get(teacherName));
//
//        studentTeacherHashMap.remove(teacherName);
//        teacherHashMap.remove(teacherName);
//        for (String s : l) {
//            studentHashMap.remove(s);
//        }
//    }
//
//    public void deleteAllTeachers() {
//        List<String> l = new ArrayList<>();
//        for (String s : studentTeacherHashMap.keySet()) {
//            l.addAll(studentTeacherHashMap.get(s));
//        }
//
//        studentTeacherHashMap.clear();
//        teacherHashMap.clear();
//        for (String s : l) {
//            studentHashMap.remove(s);
//        }
//    }
//}
//public class StudentRepository {
//
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

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> studentList = new ArrayList<>();
        if(hmpair.containsKey(hmteacher.get(teacher))) {
            studentList = hmpair.get(hmteacher.get(teacher));
        }
        return studentList;
    }

    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        for(String stud: hmstudent.keySet()){
            students.add(stud);
        }
        return students;
    }


    public void deleteTeacherByName(String Tname) {
        List<String> studentslist = new ArrayList<>();
        if( hmteacher.containsKey(Tname)){
            studentslist =hmpair.get(Tname);
            for(String student : studentslist) {
                if (hmstudent.containsKey(student)){
                    hmstudent.remove(student);
                }
            }
            if (hmteacher.containsKey(Tname)) {
                hmteacher.remove(Tname);
            }
            hmpair.remove(Tname);
        }
    }

    public void deleteAllTeachers() {
        HashSet<String> studentset = new HashSet<>();
        for(String Tname: hmpair.keySet()) {
           for(String Sname: hmpair.get(Tname))
               studentset.add(Sname);
            }
        for (String sName : studentset){
            if (hmstudent.containsKey(sName)){
                hmstudent.remove(sName);
            }
        }
    }



}
