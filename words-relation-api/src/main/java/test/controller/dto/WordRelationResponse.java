package test.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import test.dao.entities.WordRelation;

@Getter
@Setter
@AllArgsConstructor
public class WordRelationResponse {

    private Iterable<WordRelation> wordRelations;
}
