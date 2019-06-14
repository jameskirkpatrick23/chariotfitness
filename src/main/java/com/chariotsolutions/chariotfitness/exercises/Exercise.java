package com.chariotsolutions.chariotfitness.exercises;

import com.chariotsolutions.chariotfitness.lifts.Lift;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String mainMuscle;
    private String secondaryMuscle;
    private String tertiaryMuscle;

    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY)
    private Set<Lift> lifts = new HashSet<>();

    public Exercise(String name, String mainMuscle, String secondaryMuscle, String tertiaryMuscle) {
        this.name = name;
        this.mainMuscle = mainMuscle;
        this.secondaryMuscle = secondaryMuscle;
        this.tertiaryMuscle = tertiaryMuscle;
    }

    public void setMuscles(String[] muscles) {
        this.mainMuscle = muscles[0];
        this.secondaryMuscle = muscles[1];
        this.tertiaryMuscle = muscles[2];
    }
    public String getMuscles() {
        return this.mainMuscle + " " + this.secondaryMuscle + " " + this.tertiaryMuscle;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + this.name + '\'' +
                ", mainMuscle='" + this.mainMuscle + '\'' +
                ", secondaryMuscle='" + this.secondaryMuscle + '\'' +
                ", tertiaryMuscle='" + this.tertiaryMuscle + '\'' +
                '}';
    }
}
