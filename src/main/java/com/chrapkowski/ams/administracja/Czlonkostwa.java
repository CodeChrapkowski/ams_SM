package com.chrapkowski.ams.administracja;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "czlonkostwa")
public class Czlonkostwa {

    @Id
    private Long idczlonkostwo;
    private String nazwa;
    private  String opis;

    public Czlonkostwa(){

    }

    public Czlonkostwa(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public Long getIdczlonkostwo() {
        return idczlonkostwo;
    }

    public void setIdczlonkostwo(Long idczlonkostwo) {
        this.idczlonkostwo = idczlonkostwo;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
