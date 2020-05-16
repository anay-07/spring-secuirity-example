package com.fincitycar.demo.service.serviceimpl;

import com.fincitycar.demo.model.MyUserDetails;
import com.fincitycar.demo.model.User;
import com.fincitycar.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserName(username);
        System.out.println("User Name: --------- "+user.get().getUserName());
        user.orElseThrow(()->  new UsernameNotFoundException("Not Found : "+username));
        return user.map(MyUserDetails::new).get();
    }
}
