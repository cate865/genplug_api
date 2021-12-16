package com.genplug.genplug.repositories;

import com.genplug.genplug.classes.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,String> {
}
