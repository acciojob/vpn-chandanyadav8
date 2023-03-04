package com.driver.model;

import javax.persistence.*;

@Entity(name = "connection")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //connection is child wrt to service provider;
    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider;
    //connection is child wrt user
     @ManyToOne
    @JoinColumn
    private User user;

    public Connection() {
    }

    public Connection(int id, ServiceProvider serviceProvider, User user) {
        this.id = id;
        this.serviceProvider = serviceProvider;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
