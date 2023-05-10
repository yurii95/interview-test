package test.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import test.dao.entities.WordRelation;
import test.dao.enums.Relation;

import java.util.List;

public interface WordsRepository extends CrudRepository<WordRelation, String> {

    List<WordRelation> findByRelation(Relation relation);
}
