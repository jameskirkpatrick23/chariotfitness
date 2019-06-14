package com.chariotsolutions.chariotfitness.weightreps;

import com.chariotsolutions.chariotfitness.lifts.Lift;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class WeightRep {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private double weight;
    private int reps;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lift lift;

    public WeightRep(double weight, int reps, Lift lift) {
        this.weight = weight;
        this.reps = reps;
        this.lift = lift;
    }

    @Override
    public String toString() {
        return "WeightRep{" +
                "id=" + id +
                ", weight='" + this.weight + '\'' +
                ", reps='" + this.reps + '\'' +
                ", lift='" + this.lift.getId() + '\'' +
                '}';
    }
}
