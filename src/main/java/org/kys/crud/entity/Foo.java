package org.kys.crud.entity;

import javax.persistence.*;

/**
 * @author liuyunkun
 * @date 2020/11/19
 */
@Table(name = "foo")
@Entity
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String address;
    private Integer extid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExtid() {
        return extid;
    }

    public void setExtid(Integer extid) {
        this.extid = extid;
    }
}
