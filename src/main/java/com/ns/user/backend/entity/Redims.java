package com.ns.user.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Redims {
    private int id;
    private String name;
    private String code;
    private Integer amount;
    private Date expire;
    private Integer max;
    private Byte enable;
    private Date createDate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "code", nullable = true, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
    @Column(name = "max", nullable = true)
    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Basic
    @Column(name = "enable", nullable = true)
    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Redims redims = (Redims) o;
        return id == redims.id &&
                Objects.equals(name, redims.name) &&
                Objects.equals(code, redims.code) &&
                Objects.equals(amount, redims.amount) &&
                Objects.equals(expire, redims.expire) &&
                Objects.equals(max, redims.max) &&
                Objects.equals(enable, redims.enable) &&
                Objects.equals(createDate, redims.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, amount, expire, max, enable, createDate);
    }
}
