package org.sportsquest.domain.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.sportsquest.domain.repositories.UserRepository;
import org.sportsquest.spring.RepoTestConfig;

/**
 * An example of unit testing with Neo4j.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepoTestConfig.class)
@Transactional
public class UserRepoIT {

	final static Logger logger = LoggerFactory.getLogger(UserRepoIT.class);
	final static String EMAILADDRESS_SUSAN = "susan@hatseflats.com";
	final static String EMAILADDRESS_NEW = "new@hatseflats.com";

	@Autowired
	protected UserRepository userRepo;

	private List<User> testUsers;

	@Before
	public void setUpTestData() {
		testUsers = DomainModelBuilder.setupUsersSallyAndSusan();
		for (User user : testUsers) {
			userRepo.save(user);
		}
	}

	@Test
	public void find_User_by_emailaddress() throws Exception {
		assertEquals(null, userRepo.findByEmailaddress("doesnotexist"));
		User founduser = userRepo.findByEmailaddress(EMAILADDRESS_SUSAN);
		assertEquals(EMAILADDRESS_SUSAN, founduser.getEmailaddress());
	}
	
	@Test
	public void empty_User_should_validate_false() {
		userRepo.save(new User(""));
	}
	
	@Test
	public void find_User_by_username() throws Exception {
		assertEquals(null, userRepo.findByUsername("doesnotexist"));
		User founduser = userRepo.findByUsername("sally");
		assertEquals("Sally", founduser.getUsername());
	}


	@Test
	public void create_new_User_twice_results_in_one_added_User() throws Exception {
		long initialNumberOfUsers = userRepo.count();

		userRepo.save(new User(EMAILADDRESS_NEW));
		userRepo.save(new User(EMAILADDRESS_NEW));
		long numberOfUsersAfterSave = userRepo.count();

		assertEquals(initialNumberOfUsers + 1, numberOfUsersAfterSave);
	}

	@Test
	public void add_peer_to_User() {
		User sally = userRepo.findByUsername("sally");
		User newPeer = userRepo.save(new User("newPeer@hatseflats.com"));
		int initialNumberOfPeers = sally.getPeers().size();
		sally.addPeer(newPeer);
		userRepo.save(sally);

		assertEquals(initialNumberOfPeers + 1, sally.getPeers().size());
		assertEquals(1, userRepo.findByEmailaddress("newPeer@hatseflats.com").getPeers().size());
	}
	
	@Test (expected=ValidationException.class)
	public final void test_empty_username_should_kickin_beanvalidation() {
		User auser = new User("testuser@hatseflats.com");
		auser.setUsername("");
		userRepo.save(auser);
	}
	
	@Test (expected=ValidationException.class)
	public final void test_invalid_emailaddress_should_kickin_beanvalidation() {
		User auser = new User("hatseflats.com");
		userRepo.save(auser);
	}
}