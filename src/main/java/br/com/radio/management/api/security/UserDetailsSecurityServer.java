package br.com.radio.management.api.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.radio.management.api.domain.exception.ResourceNotFoundException;
import br.com.radio.management.api.domain.exception.ResourceUserInactivatedException;
import br.com.radio.management.api.domain.model.UserAdmin;
import br.com.radio.management.api.domain.repository.UserRepository;
import br.com.radio.management.api.dto.User.UserLoginRequestDTO;

@Component
public class UserDetailsSecurityServer implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserAdmin> userModelRepository = userRepository.findByEmail(username);

        if (userModelRepository.isEmpty()) {

            throw new UsernameNotFoundException("Usuário ou senha inválidos.");
        }

        return userModelRepository.get();
    }

    public Boolean validateActiveUser(UserLoginRequestDTO userLogin) {
        Optional<UserAdmin> userAdmin = userRepository.findByEmail(userLogin.getEmail());
        Boolean userActive = false;
        if (userAdmin.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        } else if (userAdmin.get().getDateInativation() != null) {
            if (!userAdmin.get().getDateInativation().equals(null)) {
                throw new ResourceUserInactivatedException(
                    "Usuário inativo, cadastre-se ou peça para que o ativem novamente.");
            }
        } else {
            userActive = true;
        }

        return userActive;

    }

}
