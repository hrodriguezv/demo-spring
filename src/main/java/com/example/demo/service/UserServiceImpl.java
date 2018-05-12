/**
 * 
 */
package com.example.demo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

/**
 * @author hectorrodriguez
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * 
	 */
	public UserServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.UserService#findUserByEmail(java.lang.String)
	 */
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.UserService#saveUser(com.example.demo.model.User)
	 */
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role role = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);
	}

}
