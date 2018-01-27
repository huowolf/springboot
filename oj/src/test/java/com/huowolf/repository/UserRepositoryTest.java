package com.huowolf.repository;

import com.huowolf.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void save() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("11111111");
		user.setEmail("xxx@qq.com");
		user.setLastLoginTime(new Date());
		User result = userRepository.save(user);
		log.info(result.toString());
		Assert.assertNotNull(result);
	}

	@Test
	public void findAll(){
	List<User> userList =  userRepository.findAll();
		log.info(userList.toString());
	}

}
