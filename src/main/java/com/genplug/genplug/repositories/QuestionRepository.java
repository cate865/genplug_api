package com.genplug.genplug.repositories;

import com.genplug.genplug.classes.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
}
