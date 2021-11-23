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
public class ProjectType {

    @Id
    @GeneratedValue
    private Long id;

    private boolean isPayType; //if false = T&M
    private boolean isPO; //if false = PAK
    private boolean isMVP;
    private boolean isFromScratch;

    public ProjectType(boolean isPayType, boolean isPO, boolean isMVP, boolean isFromScratch) {
        this.isPayType = isPayType;
        this.isPO = isPO;
        this.isMVP = isMVP;
        this.isFromScratch = isFromScratch;
    }
}
