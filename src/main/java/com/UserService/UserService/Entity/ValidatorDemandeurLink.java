package com.UserService.UserService.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "validator_demandeur_link")
@Data
public class ValidatorDemandeurLink {

    @EmbeddedId
    private ValidatorDemandeurLinkId id;

    @MapsId(value = "validatorId")
    @ManyToOne
    @JoinColumn(name = "validator_id", referencedColumnName = "user_id")
    private Validator validator;

    @MapsId(value = "demandeurId")
    @ManyToOne
    @JoinColumn(name = "demandeur_id", referencedColumnName = "user_id")
    private Demandeur demandeur;

}

