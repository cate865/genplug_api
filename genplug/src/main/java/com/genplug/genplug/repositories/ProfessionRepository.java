package com.genplug.genplug.repositories;

import com.genplug.genplug.classes.Profession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends CrudRepository<Profession,Long> {

}
