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

    private boolean isActive;
    private boolean isDraft;
//    private Technology technology;

    private TeamInfo teamInfo;
    private ProjectType projectType;
    private WorkingConditions workingConditions;

}
