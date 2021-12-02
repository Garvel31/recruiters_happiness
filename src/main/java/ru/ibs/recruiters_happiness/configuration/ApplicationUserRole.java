package ru.ibs.recruiters_happiness.configuration;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.ibs.recruiters_happiness.configuration.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    PM(Sets.newHashSet(PROJECTCARD_CREATE, PROJECTCARD_READ, PROJECTCARD_ARCHIVE,PROJECTCARD_UPDATE)),
    DM(Sets.newHashSet(PROJECTCARD_READ)),
    HR(Sets.newHashSet(PROJECTCARD_READ, PROJECTCARD_ARCHIVE));


    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
