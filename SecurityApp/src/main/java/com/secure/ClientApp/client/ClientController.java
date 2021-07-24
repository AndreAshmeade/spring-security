package com.secure.ClientApp.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController{

  private static final List<Client> CLIENTS = Arrays.asList(
    new Client(1, "James Bond"),
    new Client(2, "Maria Jones"),
    new Client(3, "Anna Smith")
  );

  @GetMapping(value="{clientId}")
  public Client getClient(@PathVariable("clientId") Integer clientId) {
       return CLIENTS.stream()
       .filter(client -> clientId.equals(client.getClientId()))
       .findFirst()
       .orElseThrow(() -> new IllegalStateException("client" + clientId + " does not exist"));
  }


}
