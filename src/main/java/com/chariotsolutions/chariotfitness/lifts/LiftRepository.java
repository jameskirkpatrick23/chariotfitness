package com.chariotsolutions.chariotfitness.lifts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface LiftRepository extends JpaRepository<Lift, Integer> {
}
