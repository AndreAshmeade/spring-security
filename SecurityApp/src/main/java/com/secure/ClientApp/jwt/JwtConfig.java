package com.secure.ClientApp.jwt;


import com.google.common.net.HttpHeaders;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
 public class JwtConfig {

  private String  secretKey;
  private String  tokenPrefix;
  private Integer tokenExpirationAfterDays ;


  public JwtConfig() {

  }

  public String getSecretKey() {
    return this.secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }
  

  public String getTokenPrefix() {
    return this.tokenPrefix;
  }

  public void setTokenPrefix(String tokenPrefix) {
    this.tokenPrefix = tokenPrefix;
  }

  public Integer getTokenExpirationAfterDays() {
    return this.tokenExpirationAfterDays;
  }

  public void setTokenExpirationAfterDays(Integer tokenExpirationAfterDays) {
    this.tokenExpirationAfterDays = tokenExpirationAfterDays;
  }
   
  
  public String getAuthorizationHeader(){
    return HttpHeaders.AUTHORIZATION;
  }

}

/*
 ***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in com.secure.ClientApp.jwt.JwtSecretKey required a bean of type 'com.secure.ClientApp.jwt.JwtConfig' that could not be found.


Action:

Consider defining a bean of type 'com.secure.ClientApp.jwt.JwtConfig' in your configuration.
 */
