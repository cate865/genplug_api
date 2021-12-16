package com.genplug.genplug.services;

import com.genplug.genplug.classes.Client;
import com.genplug.genplug.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    // get all account
    public List<Client> getAllClients(){
        return (List<Client>) clientRepository.findAll();
    }

    // get one account
    public Client getOneClient(String email){
        return clientRepository.findById(email).get();
    }

//    public Account findByConfirmationToken(String confirmationToken) {
//        return accountRepository.findByConfirmationToken(confirmationToken);
//    }

    // create an account
    public void addClient(Client client){

        clientRepository.save(client);
    }

    //login
    public Client loginClient(Client client){
        Client foundClient = clientRepository.findById(client.getEmail()).get();

        foundClient.setLoggedIn(true);
        return foundClient;
    }


//    // update account details
//    public Account updateAccount(String email){
//        return accountRepository.findById(email).get();
//    }


    // delete an account
    public void delclient(String email){
        boolean exists = clientRepository.existsById(email);
        if (exists){
            clientRepository.deleteById(email);
        }
        else {
            throw new IllegalStateException("ID doesn't exist");
        }
    }
}
