package it.pasqualecavallo.studentsmaterial.authorization_framework_example.dao;

import java.util.Arrays;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import it.pasqualecavallo.studentsmaterial.authorization_framework.dao.UserDao;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;

@Repository
public class UserDaoImpl implements UserDao {

	Map<String, UserDetails> users;
	
	@PostConstruct
	public void fillMap() {
		users.put("superadmin", UserDetails.builder().withClearPassword("password").withUsername("superadmin").withRoles(Arrays.asList("ROLE_SUPERADMIN", "ROLE_ADMIN")).build());
		users.put("admin", UserDetails.builder().withClearPassword("password").withUsername("admin").withRoles(Arrays.asList("ROLE_ADMIN")).build());
		users.put("moderator", UserDetails.builder().withClearPassword("password").withUsername("moderator").withRoles(Arrays.asList("ROLE_MODERATOR")).build());
		users.put("user", UserDetails.builder().withClearPassword("password").withUsername("user").withRoles(Arrays.asList("ROLE_USER")).build());
		users.put("adminmoderator", UserDetails.builder().withClearPassword("password").withUsername("adminmoderator").withRoles(Arrays.asList("ROLE_ADMIN", "ROLE_MODERATOR")).build());
		users.put("usermoderator", UserDetails.builder().withClearPassword("password").withUsername("usermoderator").withRoles(Arrays.asList("ROLE_USER", "ROLE_MODERATOR")).build());
		users.put("superadminmoderator", UserDetails.builder().withClearPassword("password").withUsername("superadminmoderator").withRoles(Arrays.asList("ROLE_SUPERADMIN", "ROLE_MODERATOR")).build());
	}
	
	
	@Override
	public UserDetails getUserByUsername(String username) {
		return users.get(username);
	}	
	
}
