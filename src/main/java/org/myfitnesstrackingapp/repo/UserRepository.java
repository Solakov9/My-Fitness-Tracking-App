package org.myfitnesstrackingapp.repo;

import aj.org.objectweb.asm.commons.Remapper;
import org.myfitnesstrackingapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsernameAndEmail(String username, String email);

    Optional<User> findByUsername(String username);
}
