package com.gamescenter.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamescenter.dto.SiteUserDTO;
import com.gamescenter.service.SiteUserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class SiteUserAPI {

    @Autowired
    private SiteUserService service;

    /**
     * Find a specific user by their id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public SiteUserDTO findById(@PathVariable long id) {
        return service.findById(id);
    }

    /**
     * Search for a user by their username
     * @param username
     * @return
     */
    @GetMapping("/search-by-username")
    public List<SiteUserDTO> findByUsernameContaining(@RequestParam String username) {
        return service.findByUsernameContaining(username);
    }
}