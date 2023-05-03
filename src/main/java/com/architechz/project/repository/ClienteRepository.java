package com.architechz.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.models.*;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long> {

    Boolean existsByUsername(String username);

    Boolean existsByNit(String Nit);

    String deleteByUsername(String username);

    Optional<Client> findByUsername(String username);
}
