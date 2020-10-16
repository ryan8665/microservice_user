package com.ns.user.backend.repository;


import com.ns.user.backend.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contacts, Long> {


    Contacts getContactsByIdAndUsersId(Long id ,Long usersId);

    List<Contacts> findByUsersId(Long userId);
}
