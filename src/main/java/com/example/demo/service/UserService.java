/**
 * 
 */
package com.example.demo.service;

import com.example.demo.model.User;

/**
 * @author hectorrodriguez
 *
 */
public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
