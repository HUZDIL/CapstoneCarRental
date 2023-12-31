package com.lecture.capstonecarrental.repositories;


import com.lecture.capstonecarrental.domain.Role;
import com.lecture.capstonecarrental.domain.enumeration.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(UserRole name);
}
