package com.example.abc.service;

import com.example.abc.entity.Staff;
import com.example.abc.messages.Message;
import com.example.abc.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private StaffRepository staffRepository;

    public ResponseEntity<Message> checKUser(Staff staff) {
        System.out.println(staff.getUserName());
        System.out.println(staff.getPassword());
        Staff staffOptional = (Staff) staffRepository.findByUserName(staff.getUserName());
        if(staffOptional == null){
            return new ResponseEntity<>(new Message("Staff user name is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        if(!Objects.equals(staffOptional.getPassword(), staff.getPassword())){
            return new ResponseEntity<>(new Message("Password is Incorrect", HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new Message("Login Successfully", HttpStatus.OK), HttpStatus.OK);
    }
}
