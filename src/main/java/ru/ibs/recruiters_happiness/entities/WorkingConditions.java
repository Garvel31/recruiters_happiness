package ru.ibs.recruiters_happiness.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private int timeLag;
    private String procedure;

    public WorkingConditions(boolean isInOffice, boolean isTimeLag, boolean isOverTimeExpect, int timeLag, String procedure) {
        this.isInOffice = isInOffice;
        this.isTimeLag = isTimeLag;
        this.isOverTimeExpect = isOverTimeExpect;
        this.timeLag = timeLag;
        this.procedure = procedure;
    }
}
