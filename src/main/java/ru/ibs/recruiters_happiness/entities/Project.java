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
    private Long id;

    @NotNull
    private String project_name;

    @NotNull
    private String proj_stage;


    private boolean gost_doc;


    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String end_terms;


    private String func_direction, subject_area, description, problem_to_solve, projectAuthor;
    private String projectCardStats;
    private int stakeholder_number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Technology> technology;


    @OneToOne(cascade = CascadeType.ALL)
    private TeamInfo teamInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private ProjectType projectType;

    @OneToOne(cascade = CascadeType.ALL)
    private WorkingConditions workingConditions;


//    public Project(String project_name, String proj_stage, boolean gost_doc, String end_terms) {
//        this.project_name = project_name;
//        this.proj_stage = proj_stage;
//        this.gost_doc = gost_doc;
//        this.end_terms = end_terms;
//        this.technology = new LinkedList<>();
//    }

    public Project(String project_name, String proj_stage, boolean gost_doc, String end_terms, String func_direction, String subject_area,
                   String description, String problem_to_solve, String projectAuthor, String projectCardStats, int stakeholder_number) {
        this.project_name = project_name;
        this.proj_stage = proj_stage;
        this.gost_doc = gost_doc;
        this.end_terms = end_terms;
        this.func_direction = func_direction;
        this.subject_area = subject_area;
        this.description = description;
        this.problem_to_solve = problem_to_solve;
        this.projectAuthor = projectAuthor;
        this.projectCardStats = projectCardStats;
        this.stakeholder_number = stakeholder_number;
        this.technology = new LinkedList<>();

    }
}
