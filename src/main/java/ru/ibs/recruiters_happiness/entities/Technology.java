package ru.ibs.recruiters_happiness.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "id"),
                @UniqueConstraint(columnNames = "tech")
        }
)
@JsonRootName(value = "tech")
public class Technology {


    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;


    private String tech;

    public Technology(String tech) {
        this.tech = tech;
    }
}
