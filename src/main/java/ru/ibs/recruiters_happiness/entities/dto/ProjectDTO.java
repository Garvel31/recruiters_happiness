package ru.ibs.recruiters_happiness.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ibs.recruiters_happiness.entities.Technology;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

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


    private List<Technology> technology;

}
