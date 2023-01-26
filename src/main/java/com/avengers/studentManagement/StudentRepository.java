package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db = new HashMap<>();

    public Student getStudent(int admNo){
        return db.get(admNo);
    }

    public Student getStudent(String name){
        for(int i : db.keySet()){
            if(db.get(i).getName().equals(name)){
                return db.get(i);
            }
        }
        return null;
    }

    public String addStudent(Student student){
        int id = student.getAdmNo();
        db.put(id,student);
        return "Added Successfully";
    }

    public String deleteStudent(int admNo){
        if(!db.containsKey(admNo)) return "Invalid admission number ! student doesn't exist";

        db.remove(admNo);

        return "Student Deleted successfully";
    }

    public String updateStudent(int admNo,Student student){
        if(!db.containsKey(admNo)){
            return "Invalid admission number ! student doesn't exist";
        }
        db.get(admNo).setAge(student.getAge());
        db.get(admNo).setName(student.getName());
        db.get(admNo).setState(student.getState());
        return "Student Details updated successfully";
    }
}
