package it.pasqualecavallo.studentsmaterial.authorization_framework_example.dao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.pasqualecavallo.studentsmaterial.authorization_framework.dao.UserDao;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails getUserByUsername(String username) {
		UserDetails userDetails = new UserDetails();
		userDetails.setPassword(passwordEncoder.encode("password"));
		userDetails.setRoles(Arrays.asList("ROLE_USER", "ROLE_CUSTOMER"));
		userDetails.setUsername(username);
		return userDetails;
	}	
	
}
