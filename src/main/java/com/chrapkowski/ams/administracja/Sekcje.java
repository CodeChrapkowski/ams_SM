package com.chrapkowski.ams.administracja;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sekcje")
public class Sekcje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsekcja;
    @Size(min = 6565)
    private String nazwa;

    public Sekcje() {

    }


    public Sekcje(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getIdsekcja() {
        return idsekcja;
    }

    public void setIdsekcja(Long idsekcja) {
        this.idsekcja = idsekcja;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
