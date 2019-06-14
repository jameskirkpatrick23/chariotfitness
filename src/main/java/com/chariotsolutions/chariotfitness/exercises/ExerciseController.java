package com.chariotsolutions.chariotfitness.exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExerciseController {
    @Autowired
    public ExerciseRepository exerciseRepository;

    @GetMapping("/exercises")
    public List<Exercise> index() {
        return exerciseRepository.findAll();
    }

    @GetMapping("/exercises/{id}")
    public Exercise show(@PathVariable String id) {
        int exerciseId = Integer.parseInt(id);
        return exerciseRepository.findById(exerciseId).orElse(null);
    }

    @PostMapping("/exercises/search")
    public List<Exercise> search(@RequestParam Map<String, String> body) {
        String searchTerm = body.get("text");
        return exerciseRepository.findByNameContainingOrMainMuscleContaining(searchTerm, searchTerm);
    }

    @PostMapping("/exercises")
    public Exercise create(@RequestParam Map<String, String> body){
        String name = body.get("name");
        String mainMuscle = body.get("mainMuscle");
        String secondaryMuscle = body.get("secondaryMuscle");
        String tertiaryMuscle = body.get("tertiaryMuscle");
        return exerciseRepository.save(new Exercise(name, mainMuscle, secondaryMuscle, tertiaryMuscle));
    }

    @PutMapping("/exercises/{id}")
    public Exercise update(@PathVariable String id, @RequestBody Map<String, String> body){
        int exerciseId = Integer.parseInt(id);
        Exercise exercise = exerciseRepository.findById(exerciseId).orElse(null);
        exercise.setName(body.get("name"));
        String[] muscles = new String[]{ body.get("mainMuscle"), body.get("secondaryMuscle"), body.get("tertiaryMuscle") };
        exercise.setMuscles(muscles);
        return exerciseRepository.save(exercise);
    }

    @DeleteMapping("exercises/{id}")
    public boolean delete(@PathVariable String id){
        int exerciseId = Integer.parseInt(id);
        Exercise exercise = exerciseRepository.findById(exerciseId).orElse(null);
        exerciseRepository.delete(exercise);
        return true;
    }

}
