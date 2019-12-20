package com.cognizant.movie;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import com.cognizant.movie.model.Users;
import com.cognizant.movie.exception.UserAlreadyExistException;
import com.cognizant.movie.model.Movies;
import com.cognizant.movie.model.Role;
import com.cognizant.movie.repository.UserRepository;
import com.cognizant.movie.secutity.AppUserDetailsService;
import com.cognizant.movie.service.UserDetailService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;

@ContextConfiguration(classes = MovieCruiserApplication.class)
@SpringBootTest
public class MovieCruiserApplicationTest {
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserDetailService userDetailService;
	
	@MockBean
	UserRepository repository;

	@Test
	void contextLoads() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplicationTest.class);

	@Test
	public void testSignup() {

		LOGGER.info("Start");
		
		Set<Movies> Movies = new HashSet<Movies>();

		Users user = createUser();
		when(repository.findByUserName(user.getUserName())).thenReturn(user);

		Set<Role> role = new HashSet<Role>();
		role.add(new Role(1, "user"));
		user.setRoleList(role);

		when(repository.save(user)).thenReturn(user);
		String roleName = null;
		for (Role role1 : user.getRoleList()) {
			roleName = role1.getRole();
		}
		assertEquals("user", roleName);
		LOGGER.info("End");
	}

	private Users createUser() {
		Set<Movies> Movies = new HashSet<Movies>();
		Users user = new Users(0, "user", "sdsg", "hddg",
				"$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK", Movies, null);
		return user;

	}
	
	@Test
	public void UserExistExceptionSignup(){
		
		Users user = createUser();
		when(repository.findByUserName(user.getUserName())).thenReturn(null);
		assertDoesNotThrow(() -> userDetailService.signup(user));
	}
	@Test
	public void UserExistSignup(){
		
		Users user = createUser();
		when(repository.findByUserName(user.getUserName())).thenReturn(user);
		assertThrows(UserAlreadyExistException.class,() -> userDetailService.signup(user));
	}
}
