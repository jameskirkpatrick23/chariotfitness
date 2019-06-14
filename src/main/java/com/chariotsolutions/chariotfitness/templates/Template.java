package com.chariotsolutions.chariotfitness.templates;

import com.chariotsolutions.chariotfitness.program.Program;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Object[] structure;

    @ManyToOne(fetch = FetchType.LAZY)
    private Program program;

    public Template(String name, Object[] structure, Program program) {
        this.name = name;
        this.structure = structure;
        this.program = program;
    }

    public int getProgramId() { return this.program.getId(); }

    @Override
    public String toString() {
        return "template{" +
                "id=" + id +
                ", name='" + this.name + '\'' +
                ", structure='" + this.structure.toString() + '\'' +
                ", program='" + this.program.getName() + '\'' +
                '}';
    }
}
