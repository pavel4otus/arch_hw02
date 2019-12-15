package ru.pavel2107.arch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity.ignoring().antMatchers( "/");
    }


    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()

                .authorizeRequests()
                    .antMatchers( "/").permitAll()
                    .antMatchers( "/h2-console").permitAll()
                    //
                    // страны могут просматривать все, изменять только админ
                    //
                    .antMatchers( HttpMethod.GET, "/rest/country").permitAll()
                    .antMatchers( HttpMethod.DELETE, "/rest/country").hasRole( "ADMIN")
                    .antMatchers( HttpMethod.PUT, "/rest/country").hasRole( "ADMIN")
                    //
                    // товары могут просматривать все, изменять только admin
                    //
                    .antMatchers( HttpMethod.GET, "/rest/goods").permitAll()
                    .antMatchers( HttpMethod.POST, "/rest/goods").hasRole( "ADMIN")
                    .antMatchers( HttpMethod.DELETE, "/rest/goods").hasRole( "ADMIN")
                    .antMatchers( HttpMethod.PUT, "/rest/goods").hasRole( "ADMIN")
                    //
                    // склады могут просматривать все, изменять только admin
                    //
                    .antMatchers( HttpMethod.GET, "/rest/warehouses").permitAll()
                    .antMatchers( HttpMethod.POST, "/rest/warehouses").hasRole( "ADMIN")
                    .antMatchers( HttpMethod.DELETE, "/rest/warehouses").hasRole( "ADMIN")
                    .antMatchers( HttpMethod.PUT, "/rest/warehouses").hasRole( "ADMIN")
                    //
                    // у пользователей другая логика. Каждый может создать пользователя, все остальные действия
                    // может делать только админ. удалять пользователей нельзя, можно только disable/enable
                    //
                    .antMatchers( HttpMethod.POST, "/rest/users/register").permitAll()
                    .antMatchers( HttpMethod.GET, "/rest/users/findByEmail").hasRole( "ADMIN")
                    .antMatchers( HttpMethod.GET, "/rest/users").hasRole( "ADMIN")
                    .antMatchers( HttpMethod.POST, "/rest/users").hasRole( "ADMIN")
                    .antMatchers( HttpMethod.PUT, "/rest/users").hasRole( "ADMIN")

                .and().formLogin()

                .and().httpBasic()

                .and().anonymous().principal(
                new UserDetails() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        List<GrantedAuthority> authorities = new ArrayList<>();
                        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                        return authorities;
                    }

                    @Override
                    public String getPassword() {
                        return "guest";
                    }

                    @Override
                    public String getUsername() {
                        return "guest";
                    }

                    @Override
                    public boolean isAccountNonExpired() {
                        return true;
                    }

                    @Override
                    public boolean isAccountNonLocked() {
                        return true;
                    }

                    @Override
                    public boolean isCredentialsNonExpired() {
                        return true;
                    }

                    @Override
                    public boolean isEnabled() {
                        return true;
                    }
                }
                    );



    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
