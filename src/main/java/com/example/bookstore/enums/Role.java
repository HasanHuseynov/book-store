package com.example.bookstore.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ROLE_ADMIN(Collections.emptySet()),
    ADMIN(
            Set.of(
                    Permission.ADMIN_READ,
                    Permission.ADMIN_UPDATE,
                    Permission.ADMIN_DELETE,
                    Permission.ADMIN_CREATE,
                    Permission.AUTHOR_READ,
                    Permission.AUTHOR_UPDATE,
                    Permission.AUTHOR_DELETE,
                    Permission.AUTHOR_CREATE,
                    Permission.STUDENT_READ,
                    Permission.STUDENT_UPDATE,
                    Permission.STUDENT_DELETE,
                    Permission.STUDENT_CREATE
            )
    ),
    AUTHOR(
            Set.of(
                    Permission.AUTHOR_READ,
                    Permission.AUTHOR_UPDATE,
                    Permission.AUTHOR_DELETE,
                    Permission.AUTHOR_CREATE
            )
    ),
    STUDENT(
            Set.of(
                    Permission.STUDENT_READ,
                    Permission.STUDENT_UPDATE,
                    Permission.STUDENT_DELETE,
                    Permission.STUDENT_CREATE
            )
    );


    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}