package com.ns.user.backend.dto;

import java.io.Serializable;

public class ContactDto implements Serializable {
    private Long id;
    private String phone;
    private String name;

    public ContactDto() {
    }

    public ContactDto(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public ContactDto(Long id ,String phone, String name) {
        this.id = id;
        this.phone = phone;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
