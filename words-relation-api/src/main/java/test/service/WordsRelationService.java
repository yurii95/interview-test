package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.entities.WordRelation;
import test.dao.repositories.WordsRepository;

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

    public Iterable<WordRelation> findAllWordRelations() {
        return wordsRepository.findAll();
    }

}
