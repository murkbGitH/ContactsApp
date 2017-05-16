package com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Pawel on 2017-05-12.
 */

@Entity
public class MainContactCategory implements Serializable{

    @Id
    private int id;

    private String category;

    @OneToMany(targetEntity = Contact.class, mappedBy = "mainContactCategory", cascade = CascadeType.ALL)
    private List<Contact> contactList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainContactCategory that = (MainContactCategory) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
