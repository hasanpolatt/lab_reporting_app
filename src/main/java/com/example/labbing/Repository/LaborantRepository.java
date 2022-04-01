package com.example.labbing.Repository;

import com.example.labbing.Model.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant, Long> {
    Optional<List<Laborant>> findByNameAndSurname(String name, String surname);

}
