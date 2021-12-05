package ru.ibs.recruiters_happiness.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.ibs.recruiters_happiness.auth.db.AppUser;
import ru.ibs.recruiters_happiness.configuration.ApplicationUserRole;

import java.util.Collection;

@RequiredArgsConstructor
public class ApplicationUser extends AppUser implements UserDetails {
    public ApplicationUser(final AppUser appUser) {
        super(appUser);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return ApplicationUserRole.valueOf(super.getRole()).getAuthorities();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
}
