package com.cognizant.tryuyum.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.UserAlreadyExistException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.Role;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.service.AppUserDetailsService;
import com.cognizant.truyum.service.UserDetailService;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = TruyumApplication.class)
@SpringBootTest
public class UserDetailServiceMockTest {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserDetailService userDetailService;

	@Test
	void contextLoads() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceMockTest.class);

	@Test
	public void testSignup() {

		LOGGER.info("Start");
		UserRepository repository = Mockito.mock(UserRepository.class);

		Set<MenuItem> menuItem = new HashSet<MenuItem>();

		Users user = createUser();
		when(repository.findByUserName(user.getUserName())).thenReturn(user);

		Set<Role> role = new HashSet<Role>();
		role.add(new Role(1, "user"));
		user.setRoleList(role);

		when(repository.save(user)).thenReturn(user);
		System.out.println(user.getRoleList());
		String roleName = null;
		for (Role role1 : user.getRoleList()) {
			roleName = role1.getRole();
		}
		assertEquals("user", roleName);
		LOGGER.info("End");
	}

	private Users createUser() {
		Set<MenuItem> menuItem = new HashSet<MenuItem>();
		Users user = new Users(0, "user", "sdsg", "hddg",
				"$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK", menuItem, null);
		return user;

	}

	@Test
	public void UserExitExceptionSignup() throws UserAlreadyExistException {
		UserRepository repository = Mockito.mock(UserRepository.class);
		Users user = new Users(0, "user", "sdsg", "hddg",
				"$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK", null, null);
		when(repository.findByUserName(user.getUserName())).thenReturn(null);
		assertThrows(UserAlreadyExistException.class, () -> userDetailService.signup(user));
	}

}
