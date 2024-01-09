package com.UserService.UserService.Repository;

import com.UserService.UserService.Entity.User;
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

    @Query(value = "select user.user_id, user.login,user.password from user join projet_gei_057.demandeur d on user.user_id = d.user_id",nativeQuery = true)
    List<User> findAllDemandeur();

    @Query(value = "select user.user_id, user.login,user.password from user join projet_gei_057.benevole b on user.user_id = b.user_id",nativeQuery = true)
    List<User> findAllBenevole();

    @Query(value = "select user.user_id, user.login,user.password from user join projet_gei_057.validator v on user.user_id = v.user_id",nativeQuery = true)
    List<User> findAllValidator();


}
