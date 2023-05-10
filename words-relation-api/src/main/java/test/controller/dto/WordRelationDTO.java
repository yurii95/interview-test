package test.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import test.dao.enums.Relation;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WordRelationDTO {

    @Pattern(regexp = "([A-Za-z ]+)",message = "Only chars [A-Z] and spaces are allowed")
    private String word1;

    @Pattern(regexp = "([A-Za-z ]+)",message = "Only chars [A-Z] and spaces are allowed")
    private String word2;

    private Relation relation;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(hidden = true)
    private Boolean isInversion;
}
