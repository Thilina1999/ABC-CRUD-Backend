package com.example.abc.validation;

import com.example.abc.entity.Student;
import com.example.abc.messages.Message;
import com.example.abc.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentValidation {
    public ResponseEntity<Message> checkStudent(Student student, StudentRepository studentRepository){
        if(student.getIndexNo().isEmpty() || student.getName().isEmpty() || student.getDateOfBirth() == null) {
            return new ResponseEntity<>(new Message("Please fill field correct", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
