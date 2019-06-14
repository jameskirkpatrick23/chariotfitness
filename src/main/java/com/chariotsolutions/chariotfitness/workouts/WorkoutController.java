package com.chariotsolutions.chariotfitness.workouts;

import com.chariotsolutions.chariotfitness.templates.Template;
import com.chariotsolutions.chariotfitness.templates.TemplateRepository;
import com.chariotsolutions.chariotfitness.users.User;
import com.chariotsolutions.chariotfitness.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WorkoutController {
    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/workouts")
    public List<Workout> index() { return workoutRepository.findAll(); }

    @GetMapping("/workouts/{id}")
    public Workout show(@PathVariable String id) {
        int workoutId = Integer.parseInt(id);
        return workoutRepository.findById(workoutId).orElse(null);
    }

    @PostMapping("/workouts")
    public Workout create(@RequestParam Map<String, String> body) {
        int userId = Integer.parseInt(body.get("userId"));
        User user = userRepository.findById(userId).orElse(null);
        int templateId = Integer.parseInt(body.get("templateId"));
        Template template = templateRepository.findById(templateId).orElse(null);
          return workoutRepository.save(new Workout(user, template));
    }

    @DeleteMapping("/workouts/{id}")
    public boolean delete(@PathVariable String id) {
        int workoutId = Integer.parseInt(id);
        Workout workout = workoutRepository.findById(workoutId).orElse(null);
        workoutRepository.delete(workout);
        return true;
    }
}
