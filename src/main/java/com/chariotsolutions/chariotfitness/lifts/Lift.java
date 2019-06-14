package com.chariotsolutions.chariotfitness.lifts;

import com.chariotsolutions.chariotfitness.exercises.Exercise;
import com.chariotsolutions.chariotfitness.weightreps.WeightRep;
import com.chariotsolutions.chariotfitness.workouts.Workout;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Lift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "lift", fetch = FetchType.LAZY)
    private Set<WeightRep> weightReps = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

    public Lift(Exercise exercise, Workout workout) {
        this.exercise = exercise;
        this.workout = workout;
    }

    public int getExerciseId() {
        return this.exercise.getId();
    }

    public int getWorkoutId() { return this.workout.getId(); }

    @Override
    public String toString() {
        StringBuilder strings = new StringBuilder();
        this.weightReps.forEach((wr) -> strings.append(wr.toString()));
        return "Lift{" +
                "id=" + id +
                ", results='" + strings + '\'' +
                ", exercise='" + this.exercise.getName() + '\'' +
                ", workout='" + this.workout.getId() + '\'' +
                '}';
    }

}
