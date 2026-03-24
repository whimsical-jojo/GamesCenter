package com.gamescenter.api;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamescenter.dto.LoginDTO;
import com.gamescenter.dto.SiteUserDTO;
import com.gamescenter.service.AccountManagementService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountManagementAPI
{
	@Autowired
	AccountManagementService service;
	
	@PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return service.login(loginDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> create(@RequestBody SiteUserDTO dto) {
        try {
            dto = service.create(dto);
            return ResponseEntity.status(201).body(dto);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody SiteUserDTO dto) {
        try {
            dto.setId(id);
            dto = (SiteUserDTO) service.update(dto);
            return ResponseEntity.ok(dto);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /* I will add this back later
    @GetMapping("/current-user")
    public ResponseEntity<SiteUserDTO> getCurrentUser(Authentication authentication) {
        SiteUserDTO currentUser = service.getCurrentUser(authentication.getName());
        if (currentUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(currentUser);
    } */

}