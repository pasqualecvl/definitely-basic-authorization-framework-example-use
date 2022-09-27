package it.pasqualecavallo.studentsmaterial.authorization_framework_example.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import it.pasqualecavallo.studentsmaterial.authorization_framework.dao.UserDao;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;

@Repository
public class UserDaoImpl implements UserDao, InitializingBean {

	Map<String, UserDetails> users = new HashMap<>();

	@Override
	public UserDetails getUserByUsername(String username) {
		return users.get(username);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		users.put("superadmin", UserDetails.builder().withClearPassword("password").withUsername("superadmin")
				.withRoles(Arrays.asList("ROLE_SUPERADMIN")).withUserId(1l).build());
		
		users.put("admin", UserDetails.builder().withClearPassword("password").withUsername("admin")
				.withRoles(Arrays.asList("ROLE_ADMIN")).withUserId(2l).build());
		
		users.put("moderator", UserDetails.builder().withClearPassword("password").withUsername("moderator")
				.withRoles(Arrays.asList("ROLE_MODERATOR")).withUserId(3l).build());
		
		users.put("user", UserDetails.builder().withClearPassword("password").withUsername("user")
				.withRoles(Arrays.asList("ROLE_USER")).withUserId(4l).build());
		
		users.put("norole", UserDetails.builder().withClearPassword("password").withUsername("norole")
				.withRoles(new ArrayList<>()).withUserId(5l).build());
		
		users.put("adminmoderator", UserDetails.builder().withClearPassword("password").withUsername("adminmoderator")
				.withRoles(Arrays.asList("ROLE_ADMIN", "ROLE_MODERATOR")).withUserId(6l).build());
		
		users.put("usermoderator", UserDetails.builder().withClearPassword("password").withUsername("usermoderator")
				.withRoles(Arrays.asList("ROLE_USER", "ROLE_MODERATOR")).withUserId(7l).build());
		
		users.put("superadminmoderator",
				UserDetails.builder().withClearPassword("password").withUsername("superadminmoderator")
						.withRoles(Arrays.asList("ROLE_SUPERADMIN", "ROLE_MODERATOR")).withUserId(7l).build());
	}

}
