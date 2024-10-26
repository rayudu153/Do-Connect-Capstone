package com.wipro.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.doc.entity.DoConnectUser;

import java.util.Optional;

public interface DoConnectUserRepository extends JpaRepository<DoConnectUser, Long> {
    Optional<DoConnectUser> findByUsername(String username);
}
