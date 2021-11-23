package ru.ibs.recruiters_happiness.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Technology {

    @Id
    @GeneratedValue
    private Long id;


    private String technologyType;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    @JsonIgnore
    private Project project;

    public Technology(String technologyType){
        this.technologyType = technologyType;

    }
}
