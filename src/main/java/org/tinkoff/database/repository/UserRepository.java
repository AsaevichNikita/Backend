package org.tinkoff.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tinkoff.database.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
    """
    SELECT u from User u
    WHERE u.fullName like %:fullName%
    """)
    Optional<User> findByUsername(@Param("fullName") String fullName);
}
