package com.ns.user.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contacts {
    private Long id;
    private String phone;
    private String name;
    private Long usersId;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false ,updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 12)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "users_id", nullable = false )
    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return id == contacts.id &&
                Objects.equals(phone, contacts.phone) &&
                Objects.equals(name, contacts.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, name);
    }
}
