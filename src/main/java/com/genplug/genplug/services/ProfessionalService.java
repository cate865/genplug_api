package com.genplug.genplug.services;

import com.genplug.genplug.classes.Professional;
import com.genplug.genplug.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {

    @Autowired
    ProfessionalRepository professionalRepository;

    // get all account
    public List<Professional> getAllProfessionals(){
        return (List<Professional>) professionalRepository.findAll();
    }

    // get one account
    public Professional getOneProfessional(String email){
        return professionalRepository.findById(email).get();
    }

//    public Account findByConfirmationToken(String confirmationToken) {
//        return accountRepository.findByConfirmationToken(confirmationToken);
//    }

    // create an account
    public void addProfessional(Professional professional){

        professionalRepository.save(professional);
    }

    //login
    public Professional loginProfessional(Professional professional){
        Professional foundProfessional = professionalRepository.findById(professional.getEmail()).get();

        foundProfessional.setLoggedIn(true);
        return foundProfessional;
    }


//    // update account details
//    public professional updateProfessional(String email){
//        return professionalRepository.findById(email).get();
//    }


    // delete an account
    public void delProfessional(String email){
        boolean exists = professionalRepository.existsById(email);
        if (exists){
            professionalRepository.deleteById(email);
        }
        else {
            throw new IllegalStateException("ID doesn't exist");
        }
    }
}
