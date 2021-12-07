package ru.ibs.recruiters_happiness.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class WorkingConditions {

    @Id
    @GeneratedValue
    private Long id;

    private boolean isInOffice, isTimeLag, isOverTimeExpect;

    private String procedure, adress, schedule;

//    @OneToOne
//    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
//    @JsonIgnore
//    private Project project;

    public WorkingConditions(boolean isInOffice, boolean isTimeLag, boolean isOverTimeExpect, String schedule, String procedure, String adress) {
        this.isInOffice = isInOffice;
        this.isTimeLag = isTimeLag;
        this.isOverTimeExpect = isOverTimeExpect;
        this.schedule = schedule;
        this.procedure = procedure;
        this.adress = adress;
    }
}
