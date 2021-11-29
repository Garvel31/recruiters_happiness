package ru.ibs.recruiters_happiness.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "id"),
                @UniqueConstraint(columnNames = "tech")
        }
)
public class Technology {


    @Id
    @GeneratedValue
    private Long id;


    private String tech;

    public Technology(String tech) {
        this.tech = tech;
    }
}
