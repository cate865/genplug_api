package com.genplug.genplug.controllers;

import com.genplug.genplug.classes.Profession;
import com.genplug.genplug.classes.Status;
import com.genplug.genplug.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProfessionController {

    @Autowired
    ProfessionService professionService;

    @PostMapping(path="/profession/add", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Profession createProfession(@RequestBody Profession profession){
        professionService.createProfession(profession);
        return profession;
    }

    @GetMapping(path="/profession/all", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Profession> viewAllProfessions(){
        return professionService.viewAllProfessions();
    }
}
