package com.ns.user.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Users {
    private Long id;
    private String name;
    private String family;
    private String description;
    private String cellphone;
    private String email;
    private String locail;
    private String salt;
    private String password;
    private String location;
    private String address;
    private String website;
    private Date expire;
    private Byte disable;
    private String loginTry;
    private Date createDate;
    private Integer deleted;

    public Users() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false ,updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "family", nullable = true, length = 45)
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cellphone", nullable = true, length = 11 ,updatable = false)
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "locail", nullable = true, length = 4)
    public String getLocail() {
        return locail;
    }

    public void setLocail(String locail) {
        this.locail = locail;
    }

    @Basic
    @JsonIgnore
    @Column(name = "salt", nullable = true, length = 45)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @JsonIgnore
    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 45)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "website", nullable = true, length = 45)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "expire", nullable = true)
    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    @Basic
    @Column(name = "disable", nullable = true)
    public Byte getDisable() {
        return disable;
    }

    public void setDisable(Byte disable) {
        this.disable = disable;
    }

    @Basic
    @Column(name = "login_try", nullable = true, length = 45)
    public String getLoginTry() {
        return loginTry;
    }

    public void setLoginTry(String loginTry) {
        this.loginTry = loginTry;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "deleted", nullable = true)
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(name, users.name) &&
                Objects.equals(family, users.family) &&
                Objects.equals(description, users.description) &&
                Objects.equals(cellphone, users.cellphone) &&
                Objects.equals(email, users.email) &&
                Objects.equals(locail, users.locail) &&
                Objects.equals(salt, users.salt) &&
                Objects.equals(password, users.password) &&
                Objects.equals(location, users.location) &&
                Objects.equals(address, users.address) &&
                Objects.equals(website, users.website) &&
                Objects.equals(expire, users.expire) &&
                Objects.equals(disable, users.disable) &&
                Objects.equals(loginTry, users.loginTry) &&
                Objects.equals(createDate, users.createDate) &&
                Objects.equals(deleted, users.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, family, description, cellphone, email, locail, salt, password, location, address, website, expire, disable, loginTry, createDate);
    }
}
