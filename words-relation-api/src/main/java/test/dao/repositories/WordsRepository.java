package test.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import test.dao.entities.WordRelation;

public interface WordsRepository extends CrudRepository<WordRelation, String> {

}
