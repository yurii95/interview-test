package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.controller.converters.WordRelationEntityConverter;
import test.controller.dto.WordRelationDTO;
import test.dao.enums.Relation;
import test.dao.repositories.WordsRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class WordsRelationService {

    private final WordsRepository wordsRepository;
    private final WordRelationEntityConverter wordRelationEntityConverter;

    @Autowired
    public WordsRelationService(WordsRepository wordsRepository, WordRelationEntityConverter wordRelationEntityConverter) {
        this.wordsRepository = wordsRepository;
        this.wordRelationEntityConverter = wordRelationEntityConverter;
    }

    public void createWordsRelation(WordRelationDTO wordRelationDTO) {
        wordRelationDTO.setWord1(prepareWord(wordRelationDTO.getWord1()));
        wordRelationDTO.setWord2(prepareWord(wordRelationDTO.getWord2()));
        wordsRepository.save(wordRelationEntityConverter.convertToEntity(wordRelationDTO));
    }

    private String prepareWord(String wordRelationDTO) {
        return wordRelationDTO.toLowerCase().strip();
    }

    public List<WordRelationDTO> findWordRelations(Relation relation, boolean showInversions) {
        List<WordRelationDTO> resultList = getWordRelationsByFilter(relation);
        if (showInversions) {
            resultList.forEach(dto -> dto.setIsInversion(false));
            resultList.addAll(getInversedList(resultList));
        }
        return resultList;
    }

    private List<WordRelationDTO> getInversedList(List<WordRelationDTO> resultList) {
        return resultList.stream()
                .map(wordRelation -> new WordRelationDTO(wordRelation.getWord2(), wordRelation.getWord1(), wordRelation.getRelation(), true))
                .collect(Collectors.toList());
    }

    private List<WordRelationDTO> getWordRelationsByFilter(Relation relation) {
        if (Objects.nonNull(relation)) {
            return wordRelationEntityConverter.convertToDtoList(wordsRepository.findByRelation(relation));
        } else {
            return wordRelationEntityConverter.convertToDtoList(wordsRepository.findAll());
        }
    }

}