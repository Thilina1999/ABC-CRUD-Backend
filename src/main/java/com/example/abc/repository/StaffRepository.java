package com.example.abc.repository;

import com.example.abc.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff findByUserName(String userName);
}
