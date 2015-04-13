package org.sportsquest.domain.services;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sportsquest.domain.model.User;
import org.sportsquest.domain.repositories.UserRepository;
import org.sportsquest.spring.RepoTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepoTestConfig.class)
public class UserAdministrationTest {

	@InjectMocks
	UserAdministrationService userAdministration;

	@Mock
	UserRepository userRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void test_username_already_exist() {
		User auser = new User("testuser@hatseflats.com");
		when(userRepo.findByUsername("Sally")).thenReturn(auser);
		userAdministration.verifyAndsetUserName(auser, "Sally");
	}
}
