package com.genplug.genplug.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.genplug.genplug.classes.Profession;
import com.genplug.genplug.classes.Professional;
import com.genplug.genplug.classes.Status;
import com.genplug.genplug.repositories.ProfessionRepository;
import com.genplug.genplug.services.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class ProfessionalController {
    @Autowired
    ProfessionalService professionalService;

    @Autowired
    ProfessionRepository professionRepository;

    //create professional account
    @PostMapping(path="/professional/create", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Professional createProfessionalAccount(@RequestBody ObjectNode objectNode){
        String name = objectNode.get("name").asText();
        String email = objectNode.get("email").asText();
        String password = objectNode.get("password").asText();
        int yearsOfExperience = objectNode.get("yearsOfExperience").asInt();
        String professionName = objectNode.get("profession").asText();

        Professional newProfessional = new Professional();

        List<Profession> professionsList = (List<Profession>) professionRepository.findAll();
        for (Profession profession:professionsList
        ) {
            if (profession.getName().equals(professionName)){
                newProfessional.setProfession(profession);
            }
        }
        newProfessional.setName(name);
        newProfessional.setEmail(email);
        newProfessional.setPassword(password);
        newProfessional.setYearsOfExperience(yearsOfExperience);

        List<Professional> professionals = professionalService.getAllProfessionals();
        for (Professional otherProfessional:professionals
        ) {
            if (otherProfessional.equals(newProfessional)){
                System.out.println(Status.USER_ALREADY_EXISTS);
            }
        }
        professionalService.addProfessional(newProfessional);
        System.out.println(Status.SUCCESS);
        return newProfessional;
    }

    // Login to professional account
    @PostMapping(path="/professional/login", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Professional loginProfessional(@RequestBody Professional professional){
        return professionalService.loginProfessional(professional);
    }

    // Get all professionals
    @GetMapping(path="/professional/all", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Professional> getAllProfessionals(){
        return professionalService.getAllProfessionals();
    }
}
