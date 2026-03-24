package com.gamescenter.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamescenter.dto.LoginDTO;
import com.gamescenter.dto.SiteUserDTO;
import com.gamescenter.mapper.SiteUserMapper;
import com.gamescenter.model.SiteUser;
import com.gamescenter.repository.SiteUserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AccountManagementService {

    @Autowired
    SiteUserRepository userRepository;

    @Autowired
    SiteUserMapper userMapper;

    //@Autowired
    //PasswordHasher passwordHasher;



    public String login(LoginDTO loginDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    /**
     * Creates a new User from a DTO
     * @param userDTO
     * @return
     */
    public SiteUserDTO create(@Valid SiteUserDTO userDTO) {
        
        SiteUser user = userMapper.toEntity(userDTO);
        //user.setPassword(passwordHasher.toHash(user.getPassword()));
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    /**
     * Updates an existing User from a DTO
     * @param userDTO
     * @return
     */
    public SiteUserDTO update(SiteUserDTO userDTO) {
        SiteUser user = userRepository.findById(userDTO.getId())
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userMapper.updateFromDTO(userDTO, user);
        user = userRepository.save(user);
        return userMapper.toDTO(user); 
    }

    /**
     * From the token returns the currently logged in user
     * @param token
     * @return
     */
    public SiteUserDTO getCurrentUser(String username) {
        return userMapper.toDTO(
                userRepository.findByUsername(username).get());
    }
    
}
