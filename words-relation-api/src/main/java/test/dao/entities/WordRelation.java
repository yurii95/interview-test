package test.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.dao.enums.Relation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "words",
        uniqueConstraints = @UniqueConstraint(columnNames = {"word1", "word2"})
)
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
