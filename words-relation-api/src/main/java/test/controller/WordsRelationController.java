package test.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.controller.dto.WordRelationDTO;
import test.controller.dto.WordRelationResponse;
import test.dao.enums.Relation;
import test.service.WordsRelationService;

@RestController
@RequestMapping(value = "/v1/words/relations",
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
public class WordsRelationController {

    private final WordsRelationService wordsRelationService;

    @Autowired
    public WordsRelationController(WordsRelationService wordsRelationService) {
        this.wordsRelationService = wordsRelationService;
    }

    @PostMapping()
    @ApiOperation(value = "Save relation between two words")
    public void createWordRelation(@Validated @ApiParam WordRelationDTO wordRelation) {
        wordsRelationService.createWordsRelation(wordRelation);
    }

    @GetMapping
    @ApiOperation(value = "Get relations")
    public WordRelationResponse getAllWordRelations(@ApiParam Relation relation,
                                                    @ApiParam boolean showInversions) {
        return new WordRelationResponse(wordsRelationService.findWordRelations(relation, showInversions));
    }

}