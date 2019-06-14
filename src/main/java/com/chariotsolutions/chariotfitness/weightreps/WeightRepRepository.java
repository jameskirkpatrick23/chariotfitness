package com.chariotsolutions.chariotfitness.weightreps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface WeightRepRepository extends JpaRepository<WeightRep, Integer> {
}
