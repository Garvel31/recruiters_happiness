package ru.ibs.recruiters_happiness.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProjectType {

    @Id
    @GeneratedValue
    private Long id;

    private boolean isPayType; //if false = T&M
    private boolean isPO; //if false = PAK
    private boolean isMVP;
    private boolean isFromScratch;

//    @OneToOne
//    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
//    @JsonIgnore
//    private Project project;

    public ProjectType(boolean isPayType, boolean isPO, boolean isMVP, boolean isFromScratch) {
        this.isPayType = isPayType;
        this.isPO = isPO;
        this.isMVP = isMVP;
        this.isFromScratch = isFromScratch;
    }


}
