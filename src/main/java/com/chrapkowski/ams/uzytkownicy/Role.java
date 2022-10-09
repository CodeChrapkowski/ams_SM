package com.chrapkowski.ams.uzytkownicy;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrole;
    private String nazwa;

    public Role() {

    }

    public Role(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getIdrole() {
        return idrole;
    }

    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}

