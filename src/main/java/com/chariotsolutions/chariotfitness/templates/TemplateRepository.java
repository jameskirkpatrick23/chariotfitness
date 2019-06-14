package com.chariotsolutions.chariotfitness.templates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface TemplateRepository extends JpaRepository<Template, Integer> {
}
