package com.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pawel on 2017-05-12.
 */

@Entity
@NamedQuery(name = "User.findUserByEmail", query = "select u from User u where u.email = :email")
public class User implements Serializable{

    public static final String FIND_BY_EMAIL = "User.findUserByEmail";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String email;

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
