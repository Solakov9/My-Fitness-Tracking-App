package org.myfitnesstrackingapp.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.myfitnesstrackingapp.model.entity.User;
import org.myfitnesstrackingapp.model.entity.dto.UserRegisterDTO;
import org.myfitnesstrackingapp.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public void register(UserRegisterDTO userRegisterDTO) {
        User user = this.modelMapper.map(userRegisterDTO, User.class);

        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(user);
    }
}
