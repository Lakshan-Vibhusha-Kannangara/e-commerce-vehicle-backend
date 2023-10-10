package com.vibhusha.repository;

import com.vibhusha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    // You can add more custom query methods if needed for your application.
}
