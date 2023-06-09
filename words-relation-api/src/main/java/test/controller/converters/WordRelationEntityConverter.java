package test.controller.converters;

import org.springframework.stereotype.Component;
import test.controller.dto.WordRelationDTO;
import test.dao.entities.WordRelation;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WordRelationEntityConverter {

    public List<WordRelationDTO> convertToDtoList(List<WordRelation> entities) {
        return entities.stream()
                .map(entity -> WordRelationDTO.builder()
                        .word1(entity.getWord1())
                        .word2(entity.getWord2())
                        .relation(entity.getRelation()).build())
                .collect(Collectors.toList());
    }

    public WordRelation convertToEntity(WordRelationDTO wordRelationDTO) {
        WordRelation wordRelation = new WordRelation();
        wordRelation.setWord1(wordRelationDTO.getWord1());
        wordRelation.setWord2(wordRelationDTO.getWord2());
        wordRelation.setRelation(wordRelationDTO.getRelation());
        return wordRelation;
    }

}