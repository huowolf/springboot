package com.huowolf.repository;

import com.huowolf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by huowolf on 2018/1/6.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
