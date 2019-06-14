package com.chariotsolutions.chariotfitness.program;

import com.chariotsolutions.chariotfitness.templates.Template;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "program", fetch = FetchType.LAZY)
    private Set<Template> templates = new HashSet<>();

    public Program() { }
    public Program(String name) {
        this.name = name;
    }

    public void addTemplate(Template template) {
        this.templates.add(template);
    }
    @Override
    public String toString() {
        return "Program{" +
                "id='" + id + '\'' +
                ", name='" + this.name + '\'' +
                ", templates'=" + '\'' +
                "}";
    }
}
