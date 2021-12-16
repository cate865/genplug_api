package com.genplug.genplug.repositories;

import com.genplug.genplug.classes.Professional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional,String> {
}
