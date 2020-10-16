package com.ns.user.backend.repository;

import com.ns.user.backend.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authorities, Long> {
    @Query(nativeQuery = true, value = "select authorities.id,authority,enable  from user_authority " +
            "inner join authorities on user_authority.authorities_id = authorities.id " +
            "where users_id = :id and enable = true")
    List<Authorities> returnAuthorityByUserId(Long id);
}
