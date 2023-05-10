package test.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import test.dao.enums.Relation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WordRelationDTO {
    private String word1;
    private String word2;
    private Relation relation;
    private Boolean isInversion;
}
