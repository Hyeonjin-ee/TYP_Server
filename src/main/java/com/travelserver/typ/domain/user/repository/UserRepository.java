package com.travelserver.typ.domain.user.repository;

import com.travelserver.typ.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
