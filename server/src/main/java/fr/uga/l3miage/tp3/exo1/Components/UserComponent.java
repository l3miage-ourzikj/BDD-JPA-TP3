package fr.uga.l3miage.tp3.exo1.Components;

import fr.uga.l3miage.tp3.exo1.exceptions.UserNotFoundException;
import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import fr.uga.l3miage.tp3.exo1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserComponent {

    private final UserRepository userRepository;
    public UserEntity getUser(String name) throws UserNotFoundException {
        return userRepository.findById(name).orElseThrow(()-> new UserNotFoundException("User not found with given name :"+ name));
    }
    public UserEntity createUser(UserEntity user){

        return userRepository.save(user);
    }
    public UserEntity updateEmail(String name,String newMail) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findById(name).orElseThrow(()->new UserNotFoundException("User not found with given name :"+ name));
        userEntity.setMail(newMail);
        return userRepository.save(userEntity);
    }

    public void deleteUser(String name){
        userRepository.deleteById(name);
    }

    public Set<UserEntity> getUserIsInDomain(String domaine){
        return userRepository.findAllByMailContaining(domaine);
    }

}
