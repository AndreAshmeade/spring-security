package com.secure.ClientApp.client;

import javax.crypto.SecretKey;

import com.secure.ClientApp.auth.ApplicationUserService;
import com.secure.ClientApp.jwt.CredentialsFilter;
import com.secure.ClientApp.jwt.JwtConfig;
import com.secure.ClientApp.jwt.JwtTokenVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ClientConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;
  private final ApplicationUserService applicationUserService;
  private final SecretKey secretKey;
  private final JwtConfig jwtConfig;

  @Autowired
  public ClientConfig(PasswordEncoder passwordEncoder,
                      ApplicationUserService applicationUserService,
                      SecretKey secretKey,
                      JwtConfig jwtConfig)
    {
    this.passwordEncoder = passwordEncoder;
    this.applicationUserService = applicationUserService;
    this.secretKey = secretKey;
    this.jwtConfig = jwtConfig;
   }
  

   @Override
  protected void configure(HttpSecurity http) throws Exception{
    http
    .csrf().disable()  
    .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
    .addFilter(new CredentialsFilter(authenticationManager(), jwtConfig, secretKey))
    .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig),CredentialsFilter.class )
    .authorizeRequests()
    .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
    .antMatchers("/api/**").hasRole(ApplicationUserRole.CLIENT.name())
    .anyRequest()
    .authenticated();
  }

  @Override 
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder);
    provider.setUserDetailsService(applicationUserService);
    return provider;
  }
}