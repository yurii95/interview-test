package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.entities.WordRelation;
import test.dao.enums.Relation;
import test.dao.repositories.WordsRepository;

import java.util.Objects;

@Service
public class WordsRelationService {

    private final WordsRepository wordsRepository;

    @Autowired
    public WordsRelationService(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    public void createWordsRelation(WordRelation wordRelation) {
        wordsRepository.save(wordRelation);
    }

    public Iterable<WordRelation> findWordRelations(Relation relation) {
        if(Objects.nonNull(relation)) {
            return wordsRepository.findByRelation(relation);
        }
        return wordsRepository.findAll();
    }

}
