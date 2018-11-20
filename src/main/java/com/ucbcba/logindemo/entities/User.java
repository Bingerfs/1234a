package com.ucbcba.logindemo.entities;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    private Integer id;

    @Column(unique=true)
    private String username;

    private String password;
    private String passwordConfirm;

    private String rol;

    private Boolean firstSession=true;

    //private List<Subcategoria> subcategorias;


    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Boolean getFirstSession() {
        return firstSession;
    }

    public void setFirstSession(Boolean firstSession) {
        this.firstSession = firstSession;
    }


    /*public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }*/
}
