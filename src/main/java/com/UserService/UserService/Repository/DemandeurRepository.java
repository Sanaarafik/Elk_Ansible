package com.UserService.UserService.Repository;

import com.UserService.UserService.Entity.Demandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeurRepository extends JpaRepository<Demandeur,Long> {
}
