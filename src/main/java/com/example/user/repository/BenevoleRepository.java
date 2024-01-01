package com.example.user.repository;

import com.example.user.entity.Benevole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenevoleRepository extends JpaRepository<Benevole,Long> {
}
