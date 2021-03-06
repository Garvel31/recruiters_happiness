package ru.ibs.recruiters_happiness.auth.db;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface DbApplicationUserDAO extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

}
