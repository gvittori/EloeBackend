package com.Proyecto.EloeApp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.Proyecto.EloeApp.Models.Usuario;

@Configuration
public class SecurityConfiguration {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Value("$(spring.queries.usuario-query)")
	private String queryUsuarios;
	
	@Value("$(spring.queries.roles-query)")
	private String queryRoles;
	
	/*@Bean
    public UserDetailsManager usuarios(DataSource dataSource) {
        JdbcUserDetailsManager usu = new JdbcUserDetailsManager(dataSource);
        usu.
        return usu;
    }*/
	
	
/*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/registro ").hasAnyAuthority("Admin", "Mantenimiento")
            .anyRequest().authenticated()
            .and()
            .cors().disable().formLogin()
            .loginPage("/login")
            
            ;
        return http.build();
    }*/
}
