package com.secure.ClientApp.client;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/clients")
public class ClientManagementContoller {

  private static final List<Client> CLIENTS = Arrays.asList(
    new Client(1, "James Bond"),
    new Client(2, "Tom Jones"),
    new Client(3, "Anna Smith")
  );
  
// hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('ROLE_') hasAnyAuthority('permission')


  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_ADMINTRAINEE')")
  public List<Client> getAllClients(){
    System.out.println("getAlClients");
    return CLIENTS;
  }

  @PostMapping
  @PreAuthorize("hasAuthority('client:write')")
  public void registerNewClient(@RequestBody Client client){
    System.out.println("registerNewClient");
    System.out.println(client);
  };

  @DeleteMapping(path = "{clientId}")
  @PreAuthorize("hasAuthority('client:write')")
  public void deleteClient(@PathVariable("clientId") Integer clientId){
    System.out.println("deleteClient");
    System.out.println(clientId);
  }

  @PutMapping(path = "{clientId}")
  @PreAuthorize("hasAuthority('client:write')")
  public void updateClient(@PathVariable("clientId") Integer clientId, @RequestBody Client client){
    System.out.println("updateClient");
    System.out.println(String.format("%s %s", clientId, client));
  }

}
