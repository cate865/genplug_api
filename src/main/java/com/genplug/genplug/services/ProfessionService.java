package com.genplug.genplug.services;

import com.genplug.genplug.classes.Profession;
import com.genplug.genplug.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionService {
    @Autowired
    ProfessionRepository professionRepository;

    public void createProfession(Profession profession){
        professionRepository.save(profession);
    }

    public List<Profession> viewAllProfessions(){
        return (List<Profession>) professionRepository.findAll();
    }
}
