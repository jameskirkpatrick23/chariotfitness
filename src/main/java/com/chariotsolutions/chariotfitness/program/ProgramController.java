package com.chariotsolutions.chariotfitness.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramController {
    @Autowired
    ProgramRepository programRepository;

    @GetMapping("/programs")
    public List<Program> index() {return programRepository.findAll(); }

    @GetMapping("/programs/{id}")
    public Program show(@PathVariable String id) {
        int programId = Integer.parseInt(id);
        return this.programRepository.findById(programId).orElse(null);
    }

    @PostMapping("/programs")
    public Program create(@RequestParam Map<String, String> body) {
        String name = body.get("name");
        return programRepository.save(new Program(name));
    }

    @PutMapping("/programs/{id}")
    public Program update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int programId = Integer.parseInt(id);
        Program program = this.programRepository.findById(programId).orElse(null);
        if (program != null) {
            program.setName(body.get("name"));
            return programRepository.save(program);
        } else {
            return null;
        }
    }
//
//    @DeleteMapping("/programs/{id}")
//    public boolean delete(@PathVariable String id) {
//        int programId = Integer.parseInt(id);
//        Optional<Program> programOptional = this.programRepository.findById(programId);
//        if (programOptional.isPresent()) {
//            programRepository.delete(programOptional);
//            return true;
//        } else {
//            return false;
//        }
//    }
}
