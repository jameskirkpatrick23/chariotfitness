package com.chariotsolutions.chariotfitness.workouts;

import com.chariotsolutions.chariotfitness.lifts.Lift;
import com.chariotsolutions.chariotfitness.templates.Template;
import com.chariotsolutions.chariotfitness.users.User;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "workout", fetch = FetchType.LAZY)
    private Set<Lift> lifts;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Template template;

    public Workout(User user, Template template) {
      this.user = user;
      this.template = template;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", user='" + this.user.getName() + '\'' +
                ", template='" + this.template.getName() + '\'' +
                '}';
    }

}
