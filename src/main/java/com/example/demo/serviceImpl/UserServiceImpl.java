package com.example.demo.serviceImpl;

import com.example.demo.entity.Benevole;
import com.example.demo.entity.Demandeur;
import com.example.demo.entity.User;
import com.example.demo.entity.Validator;
import com.example.demo.entityDTO.RoleDTO;
import com.example.demo.entityDTO.UserDTO;
import com.example.demo.repository.BenevoleRepository;
import com.example.demo.repository.DemandeurRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.ValidatorRepository;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BenevoleRepository benevoleRepository;

    @Autowired
    private DemandeurRepository demandeurRepository;

    @Autowired
    private ValidatorRepository validatorRepository;

    @Override
    public Stream<UserDTO> getAllUsers() {
        return userRepository.findAllLoginAndId().stream().map(user -> modelMapper.map(user, UserDTO.class));}

    @Override
    public void putUser(User user) {

    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void createNewUser(User user) {

        if (userRepository.findUserByLogin(user.getLogin()).isPresent()){
            logger.error("Login already used");
        }else {
            User new_user = new User();
            new_user.setLogin(user.getLogin());
            new_user.setPassword(user.getPassword());
            new_user.setIsBenevole(user.getIsBenevole());
            new_user.setIsValidator(user.getIsValidator());
            new_user.setIsDemandeur(user.getIsDemandeur());
            userRepository.save(new_user);
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
        return userRepository.findUserByLogin(Login);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public Optional<User> updateUser(Long id, RoleDTO roleDTO) {
        logger.info("in userService : updateUser");
        Optional<User> updatedUser = getUserById(id);
        if (updatedUser.isEmpty()){
            logger.error("No user Found");
            return Optional.empty();
        }
        logger.info(roleDTO.toString());

        updatedUser.get().setIsDemandeur(roleDTO.getIsDemandeur());
        updatedUser.get().setIsValidator(roleDTO.getIsValidator());
        updatedUser.get().setIsBenevole(roleDTO.getIsBenevole());

        if (demandeurRepository.existsById(id)){
            logger.info("user exist in table demandeur");
            if(!updatedUser.get().getIsDemandeur()){
                logger.info("deleting user");
                demandeurRepository.deleteById(id);
            }
        }
        else{
            if(updatedUser.get().getIsDemandeur()){
                Demandeur new_demandeur = new Demandeur();
                new_demandeur.setUser(updatedUser.get());
                demandeurRepository.save(new_demandeur);
            }
        }
        if (benevoleRepository.existsById(id)){
            if(!updatedUser.get().getIsBenevole()){
                benevoleRepository.deleteById(id);
            }
        }
        else{
            if(updatedUser.get().getIsBenevole()){
                Benevole new_benevole = new Benevole();
                new_benevole.setUser(updatedUser.get());
                benevoleRepository.save(new_benevole);
            }
        }

        logger.info(updatedUser.toString());

        logger.info("user updated");
        return updatedUser;
    }

    @Override
    public Stream<UserDTO> getAllDemandeur() {
        return userRepository.findAllDemandeur().stream().map(user -> modelMapper.map(user, UserDTO.class));
    }

    @Override
    public Stream<UserDTO> getAllBenevole() {
        return userRepository.findAllBenevole().stream().map(user -> modelMapper.map(user, UserDTO.class));
    }


}
