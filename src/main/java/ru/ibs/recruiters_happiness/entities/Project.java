package ru.ibs.recruiters_happiness.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Project {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String project_name;

    @NotNull
    private String proj_stage;


    private boolean gost_doc;


    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String end_terms;


    private String func_direction, subject_area, description, problem_to_solve;
    private int stakeholder_number;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Technology> technology;

    public Project(String project_name, String proj_stage, boolean gost_doc, String end_terms) {
        this.project_name = project_name;
        this.proj_stage = proj_stage;
        this.gost_doc = gost_doc;
        this.end_terms = end_terms;
        this.technology = new LinkedList<>();
    }

}
