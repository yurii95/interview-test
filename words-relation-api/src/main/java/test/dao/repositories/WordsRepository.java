package test.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.dao.entities.WordRelation;
import test.dao.enums.Relation;

import java.util.List;

public interface WordsRepository extends JpaRepository<WordRelation, String> {

    List<WordRelation> findByRelation(Relation relation);
}
