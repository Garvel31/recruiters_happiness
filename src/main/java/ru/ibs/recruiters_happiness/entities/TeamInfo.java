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
public class TeamInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String devMetodology;

    private boolean ProductDev, TeamFormed;

    private int analiticsNumber, devsNumber, testerNumber, techpisNumber, designerNumber, frontNumber, backNumber, fullstackNumber;
    private int allTeamNumber;

//    @OneToOne
//    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
//    @JsonIgnore
//    private Project project;

    public TeamInfo(String devMetodology, boolean ProductDev, boolean TeamFormed, int analiticsNumber, int devsNumber, int testerNumber,
                    int techpisNumber, int designerNumber, int frontNumber, int backNumber, int fullstackNumber) {
        this.devMetodology = devMetodology;
        this.ProductDev = ProductDev;
        this.TeamFormed = TeamFormed;
        this.analiticsNumber = analiticsNumber;
        this.devsNumber = devsNumber;
        this.testerNumber = testerNumber;
        this.techpisNumber = techpisNumber;
        this.designerNumber = designerNumber;
        this.frontNumber = frontNumber;
        this.backNumber = backNumber;
        this.fullstackNumber = fullstackNumber;
        //this.allTeamNumber = fullstackNumber + backNumber + frontNumber + designerNumber + techpisNumber + testerNumber + devsNumber + analiticsNumber;

    }
}
