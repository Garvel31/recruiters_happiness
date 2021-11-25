package ru.ibs.recruiters_happiness.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDateTime created;
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDateTime updated;

    @Column(name = "created", updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    @Column(name = "updated", insertable = false)
    public LocalDateTime getUpdated() {
        return updated;
    }

    @PrePersist
    public void toCreate() {
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdate() {
        setUpdated(LocalDateTime.now());
    }


    private String project_name;


    private String customer;


    private String proj_stage;


    private boolean gost_doc;
    private boolean active = true;
    private boolean draft = false;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String end_terms;


    private String func_direction, subject_area, description, problem_to_solve, projectAuthor, technology;
    private int stakeholder_number;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
//    private List<Technology> technology;


    @OneToOne(cascade = CascadeType.ALL)
    private TeamInfo teamInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private ProjectType projectType;

    @OneToOne(cascade = CascadeType.ALL)
    private WorkingConditions workingConditions;


    public Project(String project_name, String customer, String proj_stage, boolean gost_doc, String end_terms, String func_direction, String subject_area,
                   String description, String problem_to_solve, String projectAuthor, int stakeholder_number, String technology) {
        this.project_name = project_name;
        this.customer = customer;
        this.proj_stage = proj_stage;
        this.gost_doc = gost_doc;
        this.end_terms = end_terms;
        this.func_direction = func_direction;
        this.subject_area = subject_area;
        this.description = description;
        this.problem_to_solve = problem_to_solve;
        this.projectAuthor = projectAuthor;
        this.stakeholder_number = stakeholder_number;
        this.technology = technology;
//        this.technology = new LinkedList<>();

    }
}
