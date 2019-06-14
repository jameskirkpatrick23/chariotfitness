package com.chariotsolutions.chariotfitness.lifts;

import com.chariotsolutions.chariotfitness.exercises.Exercise;
import com.chariotsolutions.chariotfitness.exercises.ExerciseRepository;
import com.chariotsolutions.chariotfitness.workouts.Workout;
import com.chariotsolutions.chariotfitness.workouts.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LiftController {
    @Autowired
    LiftRepository liftRepository;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    WorkoutRepository workoutRepository;

    @GetMapping("/lifts")
    public List<Lift> index() { return liftRepository.findAll(); }

    @GetMapping("/lifts/{id}")
    public Lift show(@PathVariable String id) {
        int liftId = Integer.parseInt(id);
        return liftRepository.findById(liftId).orElse(null);
    }

    @PostMapping("/lifts")
    public Lift create(@RequestParam Map<String, String> body) {
//        Gson gson = new Gson();
        int exerciseId = Integer.parseInt(body.get("exerciseId"));
        int workoutId = Integer.parseInt(body.get("workoutId"));
        Exercise exercise = exerciseRepository.findById(exerciseId).orElse(null);
        Workout workout = workoutRepository.findById(workoutId).orElse(null);
//        Object[] results = gson.fromJson(body.get("results"), Object[].class);
        return liftRepository.save(new Lift(exercise, workout));
    }

    @PutMapping("/lifts/{id}")
    public Lift update(@PathVariable String id, @RequestBody Map<String, String> body){
        int liftId = Integer.parseInt(id);
        Lift lift = liftRepository.findById(liftId).orElse(null);
//        Gson gson = new Gson();
//        lift.setResults(gson.fromJson(body.get("results"), Object[].class));
        return liftRepository.save(lift);
    }

    @DeleteMapping("/lifts/{id}")
    public boolean delete(@PathVariable String id) {
        int liftId = Integer.parseInt(id);
        Lift lift = liftRepository.findById(liftId).orElse(null);
        liftRepository.delete(lift);
        return true;
    }
}
