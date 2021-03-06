package ru.ibs.recruiters_happiness.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ibs.recruiters_happiness.entities.ProjectType;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoPageDTO {

    private Long id;


    private String customer;
    private String proj_stage;

    private String projectAuthor, problem_to_solve;

    private boolean active;
    private boolean gost_doc;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDateTime created;

    private ProjectType projectType;
}
