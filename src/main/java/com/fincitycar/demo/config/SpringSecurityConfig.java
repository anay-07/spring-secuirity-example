package com.fincitycar.demo.config;

import com.fincitycar.demo.repository.UserRepository;
import com.fincitycar.demo.service.serviceimpl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Hashtable;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {


    @Autowired
    public MyUserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }



    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("anay").password("{noop}anay").roles("USER");
    }*/


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {


        httpSecurity.csrf().disable();

        /*httpSecurity.authorizeRequests()
                    .antMatchers("admin").hasRole("ADMIN")
                    .antMatchers("/user").hasRole("USER")
                    .antMatchers("/cars").hasRole("USER")
                    .anyRequest()
                    .fullyAuthenticated()
                    .and()
                    .httpBasic();*/



        httpSecurity.authorizeRequests()
                    .antMatchers("**/fincity/api/v1/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                    .formLogin().permitAll();

            //httpSecurity.csrf().disable();


        /*auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");*/

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
