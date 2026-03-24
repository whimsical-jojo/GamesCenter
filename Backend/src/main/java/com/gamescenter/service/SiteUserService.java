package com.gamescenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamescenter.dto.SiteUserDTO;
import com.gamescenter.mapper.SiteUserMapper;
import com.gamescenter.model.SiteUser;
import com.gamescenter.repository.SiteUserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SiteUserService
{
	@Autowired
	SiteUserRepository userRepository;
	
	@Autowired
	SiteUserMapper userMapper;


	public List<SiteUserDTO> findAll() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    public SiteUserDTO findById(long id) {
        SiteUser user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }


    public SiteUserDTO findByUsername(String username) {
        SiteUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username:" + username));
        return userMapper.toDTO(user);
    }

    public List<SiteUserDTO> findByUsernameContaining(String username) {
        return userMapper.toDTOs(userRepository.findByUsernameContaining(username));
    }

}
