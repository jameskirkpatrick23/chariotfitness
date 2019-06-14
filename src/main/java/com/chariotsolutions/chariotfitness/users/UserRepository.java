package com.chariotsolutions.chariotfitness.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
}