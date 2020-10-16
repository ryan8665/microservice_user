package com.ns.user.backend.repository;


import com.ns.user.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Override
    Users getOne(Long aLong);

    Users getByCellphone(String cellphone);

    void deleteByCellphone(String cellphone);

    @Query(nativeQuery = true, value = "UPDATE coredb.users t SET t.deleted = 1 WHERE t.cellphone = :cellphone")
    void setUserDeleted(String cellphone);
}
