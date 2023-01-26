package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //get information
    @GetMapping("/get_student/id/{admNo}")
    public ResponseEntity getStudent(@PathVariable("admNo") int admNo){
        Student student = studentService.getStudent(admNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @GetMapping("/get_student/name/{name}")
    public ResponseEntity getStudent(@PathVariable("name") String name){
        Student student = studentService.getStudent(name);
        return new ResponseEntity<>(student,HttpStatus.FOUND);
    }

    //adding the information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @PutMapping("/update_student/{admNo}")
    public ResponseEntity updateStudent(@PathVariable("admNo") int admNo,@RequestBody Student student){
        String response = studentService.updateStudent(admNo,student);
        if(response == null){
            return new ResponseEntity<>("Invalid request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("updated",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete_student/{admNo}")
    public ResponseEntity deleteStudent(@PathVariable("admNo") int admNo){
       String response = studentService.deleteStudent(admNo);
       if(response.equals("Invalid id")) {
           return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

}
