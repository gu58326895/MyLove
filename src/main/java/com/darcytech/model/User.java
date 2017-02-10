package com.darcytech.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import com.darcytech.enumeration.Role;
import com.darcytech.security.LoveUser;

@Entity
public class User implements LoveUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String password;

    @Column(insertable = false, updatable = false)
    private Date create_time;

    @Column(insertable = false, updatable = false)
    private Date update_time;

    private String mobile;

    @Enumerated(EnumType.STRING)
    private Role role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (getRole().equals(Role.VIP)) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new LoveAuth(Role.VIP.toString()));
            return new ArrayList<GrantedAuthority>(grantedAuthorities);
        } else if (getRole().equals(Role.COMMON)) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new LoveAuth(Role.COMMON.toString()));
            return new ArrayList<GrantedAuthority>(grantedAuthorities);
        }
        return Collections.emptyList();
    }
}
