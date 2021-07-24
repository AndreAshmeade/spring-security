package com.secure.ClientApp.client;
 
public enum ApplicationUserPermission {
  CLIENT_READ("client:read"),
  CLIENT_WRITE("client:write"),
  SERVICE_READ("service:read"),
  SERVICE_WRITE("service:write");

  private final String permission;

  ApplicationUserPermission(String permission){
    this.permission = permission;
  }

  public String getPermission(){
    return permission;
  }
}
