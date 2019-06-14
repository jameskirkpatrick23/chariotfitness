package com.chariotsolutions.chariotfitness.templates;

import com.chariotsolutions.chariotfitness.program.Program;
import com.chariotsolutions.chariotfitness.program.ProgramRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TemplateController {
    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    ProgramRepository programRepository;

    @GetMapping("/templates")
    public List<Template> index() { return templateRepository.findAll(); }

    @GetMapping("/templates/{id}")
    public Template show(@PathVariable String id) {
        int liftId = Integer.parseInt(id);
        return templateRepository.findById(liftId).orElse(null);
    }

    @PostMapping("/templates")
    public Template create(@RequestParam Map<String, String> body) {
        Gson gson = new Gson();
        int programId = Integer.parseInt(body.get("programId"));
        String name = body.get("name");
        Program program = programRepository.findById(programId).orElse(null);
        Object[] structure = gson.fromJson(body.get("structure"), Object[].class);
        return templateRepository.save(new Template(name, structure, program));
    }

    @PutMapping("/templates/{id}")
    public Template update(@PathVariable String id, @RequestBody Map<String, String> body){
        int templateId = Integer.parseInt(id);
        Gson gson = new Gson();
        Template template = templateRepository.findById(templateId).orElse(null);
        template.setStructure(gson.fromJson(body.get("structure"), Object[].class));
        template.setName(body.get("name"));
        return templateRepository.save(template);
    }

    @DeleteMapping("/templates/{id}")
    public boolean delete(@PathVariable String id) {
        int templateId = Integer.parseInt(id);
        Template template = templateRepository.findById(templateId).orElse(null);
        templateRepository.delete(template);
        return true;
    }
}
