package com.chrapkowski.ams.wyszkolenie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "zadania")
public class Zadania {

    @Id
    private Long idzadanie;
    @NotEmpty
    private String zadanie;
    @NotEmpty
    private String cwiczenie;
    @NotEmpty
    private String opis;
    @NotEmpty
    private String opis2;


    public Zadania() {
    }

    public Zadania(Long idzadanie, @NotEmpty String zadanie, @NotEmpty String cwiczenie, @NotEmpty String opis, @NotEmpty String opis2) {
        this.idzadanie = idzadanie;
        this.zadanie = zadanie;
        this.cwiczenie = cwiczenie;
        this.opis = opis;
        this.opis2 = opis2;
    }

    public Long getIdzadanie() {
        return idzadanie;
    }

    public void setIdzadanie(Long idzadanie) {
        this.idzadanie = idzadanie;
    }

    public String getZadanie() {
        return zadanie;
    }

    public void setZadanie(String zadanie) {
        this.zadanie = zadanie;
    }

    public String getCwiczenie() {
        return cwiczenie;
    }

    public void setCwiczenie(String cwiczenie) {
        this.cwiczenie = cwiczenie;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOpis2() {
        return opis2;
    }

    public void setOpis2(String opis2) {
        this.opis2 = opis2;
    }
}




