package ru.ibs.recruiters_happiness.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ibs.recruiters_happiness.entities.ProjectType;
import ru.ibs.recruiters_happiness.entities.TeamInfo;

import ru.ibs.recruiters_happiness.entities.WorkingConditions;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Long id;

    @NotNull
    private String project_name;

    @NotNull
    private String customer;

    @NotNull
    private String proj_stage;


    private boolean gost_doc;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String end_terms;

   @JsonFormat(pattern="yyyy-MM-dd")
    LocalDateTime created;
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDateTime updated;

    private String func_direction, subject_area, description, problem_to_solve, projectAuthor, technology;
    private int stakeholder_number;

    private boolean active;
    private boolean draft;


    private TeamInfo teamInfo;
    private ProjectType projectType;
    private WorkingConditions workingConditions;

//    public ProjectDTO(String project_name, String customer, String proj_stage, boolean gost_doc, String end_terms, LocalDateTime created, LocalDateTime updated, String func_direction, String subject_area, String description, String problem_to_solve, String projectAuthor, String technology, int stakeholder_number, boolean active, boolean draft, TeamInfo teamInfo, ProjectType projectType, WorkingConditions workingConditions) {
//        this.project_name = project_name;
//        this.customer = customer;
//        this.proj_stage = proj_stage;
//        this.gost_doc = gost_doc;
//        this.end_terms = end_terms;
//        this.created = created;
//        this.updated = updated;
//        this.func_direction = func_direction;
//        this.subject_area = subject_area;
//        this.description = description;
//        this.problem_to_solve = problem_to_solve;
//        this.projectAuthor = projectAuthor;
//        this.technology = technology;
//        this.stakeholder_number = stakeholder_number;
//        this.active = active;
//        this.draft = draft;
//        this.teamInfo = teamInfo;
//        this.projectType = projectType;
//        this.workingConditions = workingConditions;
//    }
}
