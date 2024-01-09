package com.UserService.UserService.Repository;

import com.UserService.UserService.Entity.Benevole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenevoleRepository extends JpaRepository<Benevole,Long> {
}
