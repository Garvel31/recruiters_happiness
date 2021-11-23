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
public class TeamInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String devMetodology;

    private boolean isProductDev, isTeamFormed;

    private int analiticsCount, devsCount, testerCount, techpisCount, allTeamCount;


    public TeamInfo(String devMetodology, boolean isProductDev, boolean isTeamFormed, int analiticsCount, int devsCount, int testerCount,
                    int techpisCount, int allTeamCount) {
            this.devMetodology = devMetodology;
            this.isProductDev = isProductDev;
            this.isTeamFormed = isTeamFormed;
            this.analiticsCount = analiticsCount;
            this.devsCount = devsCount;
            this.testerCount = testerCount;
            this.techpisCount = techpisCount;
            this.allTeamCount = allTeamCount;

    }
}
