package com.vengard.rentis.repository;

import com.vengard.rentis.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    User save(User user);

    User findByEmail(String email);

    User findByUsername(String username);
}
