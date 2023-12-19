package com.example.demo.serviceImpl;

import com.example.demo.entity.Benevole;
import com.example.demo.entity.Demandeur;
import com.example.demo.entity.User;
import com.example.demo.entity.Validator;
import com.example.demo.repository.BenevoleRepository;
import com.example.demo.repository.DemandeurRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.ValidatorRepository;
import com.example.demo.services.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BenevoleRepository benevoleRepository;

    @Autowired
    private DemandeurRepository demandeurRepository;

    @Autowired
    private ValidatorRepository validatorRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();}

    @Override
    public void putUser(User user) {

    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void createNewUser(User user) {

        if (userRepository.findUserByLogin(user.getLogin()) != null){
            logger.error("Login already used");
        }else {
            User new_user = new User();
            new_user.setLogin(user.getLogin());
            new_user.setPassword(user.getPassword());
            new_user.setIsBenevole(user.getIsBenevole());
            new_user.setIsValidator(user.getIsValidator());
            new_user.setIsDemandeur(user.getIsDemandeur());

            if (user.getIsDemandeur()) {
                Demandeur demandeur = new Demandeur();
                demandeur.setUser(new_user);
                demandeurRepository.save(demandeur);
            }
            if (user.getIsValidator()) {
                Validator validator= new Validator();
                validator.setUser(new_user);
                validatorRepository.save(validator);
            }
            if (user.getIsBenevole()) {
                Benevole benevole = new Benevole();
                benevole.setUser(new_user);
                benevoleRepository.save(benevole);
            }
        }
    }

    @Override
    public Optional<User> getUserByLogin(String Login) {
        return Optional.ofNullable(userRepository.findUserByLogin(Login));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
