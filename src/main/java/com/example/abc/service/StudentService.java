package com.example.abc.service;

import com.example.abc.entity.Student;
import com.example.abc.messages.Message;
import com.example.abc.repository.StudentRepository;
import com.example.abc.validation.StudentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentValidation studentValidation;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<Message> saveStudent(Student student) {
        if(studentValidation.checkStudent(student, studentRepository) != null){
            return studentValidation.checkStudent(student, studentRepository);
        }
        if(studentRepository.findByIndexNo(student.getIndexNo()) != null){
            return new ResponseEntity<>(new Message("Student Index Already Available", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        studentRepository.save(student);
        return new ResponseEntity<>(new Message("Product Category saved successfully", HttpStatus.OK, student), HttpStatus.OK);
    }

    public ResponseEntity<Message> updateStudent(int id, Student student){
        Student oldData = studentRepository.findById(id).orElse(null);
        if(oldData == null){
            return new ResponseEntity<>(new Message("Student not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        if(studentValidation.checkStudent(student, studentRepository) != null){
            return studentValidation.checkStudent(student, studentRepository);
        }
        oldData.setIndexNo(student.getIndexNo());
        oldData.setName(student.getName());
        oldData.setDateOfBirth(student.getDateOfBirth());
        oldData.setTelephone(student.getTelephone());
        oldData.setAddress(student.getAddress());

        studentRepository.save(oldData);
        return new ResponseEntity<>(new Message("Student saved successfully", HttpStatus.OK, oldData), HttpStatus.OK);
    }

    public ResponseEntity<Message> deleteStudent(int id) {
        Student oldData = studentRepository.findById(id).orElse(null);
        if(oldData == null){
            return new ResponseEntity<>(new Message("Student not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        studentRepository.delete(oldData);
        return new ResponseEntity<>(new Message("Student deleted successfully", HttpStatus.OK), HttpStatus.OK);
    }
}
