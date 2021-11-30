package ru.ibs.recruiters_happiness.auth.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.auth.ApplicationUser;
import ru.ibs.recruiters_happiness.auth.db.AppUser;
import ru.ibs.recruiters_happiness.auth.db.DbApplicationUserDAO;

@Service("AppUserService")
public class DbApplicationUserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final DbApplicationUserDAO dbApplicationUserDAO;

    @Autowired
    public DbApplicationUserService(PasswordEncoder passwordEncoder, DbApplicationUserDAO dbApplicationUserDAO) {
        this.passwordEncoder = passwordEncoder;
        this.dbApplicationUserDAO = dbApplicationUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = dbApplicationUserDAO.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return new ApplicationUser(appUser);
    }




}
