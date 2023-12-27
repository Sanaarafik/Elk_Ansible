package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByLogin(String login);

    @Query(value = "Select user_id,login,password from user",nativeQuery = true)
    List<User> findAllLoginAndId();

    @Query(value = "select user_id,login,password from user join projet_gei_057.demandeur d on user.user_id = d.user_id",nativeQuery = true)
    List<User> findAllDemandeur();

    @Query(value = "select user_id,login,password from user join projet_gei_057.benevole b on user.user_id = b.user_id",nativeQuery = true)
    List<User> findAllBenevole();


}
