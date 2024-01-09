package com.UserService.UserService.Repository;

import com.UserService.UserService.Entity.Demandeur;
import com.UserService.UserService.Entity.Validator;
import com.UserService.UserService.Entity.ValidatorDemandeurLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidatorDemandeurLinkRepository extends JpaRepository<ValidatorDemandeurLink,Long> {

    boolean existsByValidatorAndDemandeur(Validator validator, Demandeur demandeur);
}
