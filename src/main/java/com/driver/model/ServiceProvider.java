package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="serviceProvider")
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    //service provider is child wrt admin
    //setting the foreign attribute
    //unidirectional mapping
    @ManyToOne
    @JoinColumn
    private Admin admin;

    //service provider is parent wrt to conncetion
    @OneToMany(mappedBy = "connection",cascade = CascadeType.ALL)
    private List<Connection>conncectionList;

    //service provider is parent wrt to country
    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    private List<Country>countryList;
    //many to many realtion with user

    @ManyToMany(mappedBy = "serviceProviderList",cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>();

    public ServiceProvider() {
    }

    public ServiceProvider(int id, String name, Admin admin, List<Connection> conncectionList, List<Country> countryList, List<User> userList) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.conncectionList = conncectionList;
        this.countryList = countryList;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Connection> getConncectionList() {
        return conncectionList;
    }

    public void setConncectionList(List<Connection> conncectionList) {
        this.conncectionList = conncectionList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
