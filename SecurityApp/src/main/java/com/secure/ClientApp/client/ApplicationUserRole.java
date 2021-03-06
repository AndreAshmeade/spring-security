package com.secure.ClientApp.client;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.secure.ClientApp.client.ApplicationUserPermission.*;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {
  CLIENT(Sets.newHashSet()),
  ADMIN (Sets.newHashSet(SERVICE_READ,SERVICE_WRITE,CLIENT_READ,CLIENT_WRITE)),
  ADMINTRAINEE (Sets.newHashSet(SERVICE_READ,CLIENT_READ));


  private final Set<ApplicationUserPermission> permissions;

  ApplicationUserRole(Set<ApplicationUserPermission> permissions){
    this.permissions = permissions;
  }

  public Set<ApplicationUserPermission> getPermissions(){
    return permissions;
  }

  public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
    Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
    .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
    .collect(Collectors.toSet());
  permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
  return permissions;
  }

  
}
