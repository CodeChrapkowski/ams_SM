package com.chrapkowski.ams.uzytkownicy;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "uzytkownicy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Uzytkownicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduzytkownicy;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    private String email;

    private String haslo;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "uzytkownicy_role",
            joinColumns = @JoinColumn(
                    name = "uzytkownicy_iduzytkownicy", referencedColumnName = "iduzytkownicy"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_idrole", referencedColumnName = "idrole"))
    private Collection<Role> roles;

    public Uzytkownicy() {

    }



    public Uzytkownicy(String imie, String nazwisko, String email, String haslo, Collection<Role> roles) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.roles = roles;
    }

    public Long getIduzytkownicy() {
        return iduzytkownicy;
    }

    public void setIduzytkownicy(Long iduzytkownicy) {
        this.iduzytkownicy = iduzytkownicy;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}




