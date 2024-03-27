package com.cap.college_admission_portal.model.enumerate;
import java.util.Set;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.cap.college_admission_portal.model.enumerate.Permission.ADMIN_CREATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.ADMIN_DELETE;
import static com.cap.college_admission_portal.model.enumerate.Permission.ADMIN_READ;
import static com.cap.college_admission_portal.model.enumerate.Permission.ADMIN_UPDATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.STAFF_CREATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.STAFF_DELETE;
import static com.cap.college_admission_portal.model.enumerate.Permission.STAFF_READ;
import static com.cap.college_admission_portal.model.enumerate.Permission.STAFF_UPDATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.USER_CREATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.USER_DELETE;
import static com.cap.college_admission_portal.model.enumerate.Permission.USER_READ;
import static com.cap.college_admission_portal.model.enumerate.Permission.USER_UPDATE;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(
        ADMIN_READ,
        ADMIN_UPDATE,
        ADMIN_CREATE,
        ADMIN_DELETE,
        USER_READ,
        USER_UPDATE,
        USER_CREATE,
        USER_DELETE,
        STAFF_READ,
        STAFF_CREATE,
        STAFF_UPDATE,
        STAFF_DELETE
    )),
    USER(Set.of(
        USER_CREATE,
        USER_UPDATE,
        USER_READ,
        USER_DELETE
    )),
    STAFF(Set.of(
        STAFF_CREATE,
        STAFF_READ,
        STAFF_UPDATE,
        STAFF_DELETE,
        USER_READ,
        USER_UPDATE,
        USER_CREATE,
        USER_DELETE
    ));

    @Getter
    private final Set<Permission> permissions;
    public List<SimpleGrantedAuthority> getAuthority(){
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for(Permission permission : getPermissions()){
                authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
            }
            authorities.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
            return authorities;
    }

} 
