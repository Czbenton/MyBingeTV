package com.theironyard.entities;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Zach on 10/31/16.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    String name;

    @Column(nullable = false)
    String password;

    @Column
    ArrayList<Result> userList;

    public User() {

    }

    public User(String userName, String password) {
        this.name = userName;
        this.password = password;
    }

    public ArrayList<Result> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Result> userList) {
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
