package com.chariotsolutions.chariotfitness.program;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ProgramRepository extends JpaRepository<Program, Integer> {
}
