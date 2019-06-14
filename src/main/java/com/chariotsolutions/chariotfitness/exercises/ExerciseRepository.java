package com.chariotsolutions.chariotfitness.exercises;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    // custom query to search to blog post by title or content
    List<Exercise> findByNameContainingOrMainMuscleContaining(String text, String textAgain);
}