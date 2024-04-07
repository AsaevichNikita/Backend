package org.tinkoff.database.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum UserRoleDto implements GrantedAuthority {
    USER("user"),
    MENTOR("mentor");
    private final String name;
    UserRoleDto(String name) {
        this.name = name;
    }
    @Override
    public String getAuthority() {
        return name();
    }
}
