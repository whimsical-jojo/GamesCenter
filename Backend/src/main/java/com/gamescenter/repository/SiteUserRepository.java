package com.gamescenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamescenter.model.SiteUser;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {

}