package com.UserService.UserService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class ValidatorDemandeurLinkId implements Serializable {
    @Column(name = "validator_id")
    private Long validatorId;

    @Column(name = "demandeur_id")
    private Long demandeurId;

    public ValidatorDemandeurLinkId(Long validatorId, Long demandeurId) {
        this.validatorId = validatorId;
        this.demandeurId = demandeurId;
    }

    public ValidatorDemandeurLinkId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidatorDemandeurLinkId that)) return false;
        return Objects.equals(validatorId, that.validatorId) &&
                Objects.equals(demandeurId, that.demandeurId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validatorId, demandeurId);
    }
}
