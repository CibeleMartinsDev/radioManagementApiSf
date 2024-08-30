package br.com.radio.management.api.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.radio.management.api.common.ConvertDate;
import br.com.radio.management.api.domain.exception.ResourceNotFoundException;
import br.com.radio.management.api.domain.model.UserAdmin;
import br.com.radio.management.api.domain.repository.UserRepository;
import br.com.radio.management.api.dto.User.UserLoginRequestDTO;
import br.com.radio.management.api.dto.User.UserRequestDTO;
import br.com.radio.management.api.dto.User.UserResponseDTO;

// é necessário a anotação pq o serviço nao estende a interface, ele implementa
@Service
public class UserService implements CRUDService<UserRequestDTO, UserResponseDTO> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired //criptografar senha do usuário
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void deleteById(Long id) {

        // refatorou este método p/
        // não deletar o usuário do banco
        // apenas seta a data de inativacao
        // e atualiza esse usuário no banco

       Optional<UserAdmin> userOptModel = userRepository.findById(id);


       if (userOptModel.isEmpty()) {
        throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o id: " + id);
        }

        UserAdmin userModel = userOptModel.get();

        userModel.setDateInativation(ConvertDate.convertDateForDateHour(new Date()));

        userRepository.save(userModel);
    }

    @Override
    public List<UserResponseDTO> getAll() {

        // pega os usuários do BD
        List<UserAdmin> usersModel = userRepository.findAll();

        List<UserResponseDTO> usersDto = usersModel.stream().map(u -> mapper.map(u, UserResponseDTO.class)).collect(Collectors.toList());

        return usersDto;
    }

    @Override
    public UserResponseDTO getById(Long id) {

        Optional<UserAdmin> optionalUserModel = userRepository.findById(id);

        if (optionalUserModel.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        UserResponseDTO userResponseDto = mapper.map(optionalUserModel.get(), UserResponseDTO.class);

        return userResponseDto;
    }

    public UserResponseDTO getByEmail(String email) {

        Optional<UserAdmin> optionalUserModel = userRepository.findByEmail(email);

        if (optionalUserModel.isEmpty()) {
            throw new ResourceNotFoundException("Usuário com email" + email +  "não encontrado.");
        }

        UserResponseDTO userResponseDto = mapper.map(optionalUserModel.get(), UserResponseDTO.class);

        return userResponseDto;
    }

    @Override
    public UserResponseDTO register(UserRequestDTO dto) {

        // UserAdmin userModel = mapper.map(dto, UserAdmin.class);

        UserAdmin userModel = mapper.map(dto, UserAdmin.class);

        // criptografa a senha do usuário
        String passwordUser = passwordEncoder.encode(userModel.getPasswordUser());

        userModel.setPasswordUser(passwordUser);
        userModel.setId(null);
        
        userModel.setDateRegister(ConvertDate.convertDateForDateHour(new Date()));
        userModel = userRepository.save(userModel);

        UserResponseDTO userResponse = mapper.map(userModel, UserResponseDTO.class);

        return userResponse;
    }

    @Override
    public UserResponseDTO updateById(Long id, UserRequestDTO dto) {

        // obtem o usuário pelo id
        UserResponseDTO userDto = getById(id);

         // criptografa a senha do usuário
        String passwordUser = passwordEncoder.encode(dto.getPasswordUser());

        // transforma o usuario request em model
        UserAdmin userModel = mapper.map(dto, UserAdmin.class);

        userModel.setPasswordUser(passwordUser);
        // seta o id e a data de inatiacao p/ o que ja estava no banco
        userModel.setId(id);
        userModel.setDateInativation(userDto.getDateInativation());
        userModel.setDateRegister(userDto.getDateRegister());
        // salva no banco
        userModel = userRepository.save(userModel);

        UserResponseDTO userResponse = mapper.map(userModel, UserResponseDTO.class);

        return userResponse;
    }


    public void activateUser(Long id, UserRequestDTO userInactivated ) {
       // obtem o usuário pelo id
       UserResponseDTO userDto = getById(id);

       // criptografa a senha do usuário
      String passwordUser = passwordEncoder.encode(userInactivated.getPasswordUser());

      // transforma o usuario request em model
      UserAdmin userModel = mapper.map(userInactivated, UserAdmin.class);

      userModel.setPasswordUser(passwordUser);
      // seta o id, e todos os outros campos, exceto data de inativacao, para como estava no banco
      userModel.setId(id);
      userModel.setDateInativation(null);
      userModel.setDateRegister(userDto.getDateRegister());
      userModel.setEmail(userDto.getEmail());
      userModel.setNameUser(userDto.getNameUser());
      // salva no banco
      userModel = userRepository.save(userModel);
    }

}
