package ru.ibs.recruiters_happiness.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoPageDTO {

    @NotNull
    private String customer;

    private String projectAuthor;

    private boolean isActive;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDateTime created;

}
