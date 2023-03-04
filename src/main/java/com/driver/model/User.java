package com.driver.model;

import javax.persistence.*;
import java.sql.Connection;
import java.util.List;

@Entity(name = "entity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String originalIp;
    private String markedIp;
    private boolean connected;
    //user parent wrt to connection
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Connection> connectionList;

    //one to one realiton with country

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Country country;
//many to many relation with serviceprovider
    @ManyToMany
    @JoinColumn
    private List<ServiceProvider>serviceProviderList;

    public User() {
    }

    public User(int id, String username, String password, String originalIp, String markedIp, boolean connected, List<Connection> connectionList, Country country, List<ServiceProvider> serviceProviderList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.originalIp = originalIp;
        this.markedIp = markedIp;
        this.connected = connected;
        this.connectionList = connectionList;
        this.country = country;
        this.serviceProviderList = serviceProviderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginalIp() {
        return originalIp;
    }

    public void setOriginalIp(String originalIp) {
        this.originalIp = originalIp;
    }

    public String getMarkedIp() {
        return markedIp;
    }

    public void setMarkedIp(String markedIp) {
        this.markedIp = markedIp;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }

}
