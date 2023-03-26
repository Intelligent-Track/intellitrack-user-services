package com.architechz.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.models.*;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}