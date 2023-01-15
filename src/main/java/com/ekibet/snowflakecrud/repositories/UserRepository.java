package com.ekibet.snowflakecrud.repositories;

import com.ekibet.snowflakecrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
