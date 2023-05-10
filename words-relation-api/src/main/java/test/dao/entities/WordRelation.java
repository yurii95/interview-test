package test.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.dao.enums.Relation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "word-relations")
public class WordRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String word1;
    @NotBlank
    @Column(nullable = false)
    private String word2;

    @NotNull
    @Column(nullable = false)
    private Relation relation;
}
