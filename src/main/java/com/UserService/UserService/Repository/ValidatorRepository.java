package com.UserService.UserService.Repository;

import com.UserService.UserService.Entity.Benevole;
import com.UserService.UserService.Entity.Validator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidatorRepository extends JpaRepository<Validator,Long> {
}
