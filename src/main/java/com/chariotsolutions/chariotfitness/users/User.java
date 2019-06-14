package com.chariotsolutions.chariotfitness.users;

import com.chariotsolutions.chariotfitness.workouts.Workout;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean enabled;

    private String firstName;
    private String lastName;
    private String email;

    private String confirmationToken;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Workout> workouts = new HashSet<>();

    public User(String firstName, String lastName, String email, String confirmationToken, boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.confirmationToken = confirmationToken;
        this.enabled = enabled;
    }

    public String getName() { return this.firstName + " " + this.lastName; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + this.getEmail() + '\'' +
                '}';
    }
}
