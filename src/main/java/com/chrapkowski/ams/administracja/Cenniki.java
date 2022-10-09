package com.chrapkowski.ams.administracja;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cenniki")
public class Cenniki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcennik;
    @NotNull( message = "sdsds")
    private String nazwa;
    @Size(min = 6)
    private String opis;
    @Size(min = 6)
    private String cena;

/*------------*/
    private Long taryfy_idtaryfa;

    public Long getTaryfy_idtaryfa() {
        return taryfy_idtaryfa;
    }

    public void setTaryfy_idtaryfa(Long taryfy_idtaryfa) {
        this.taryfy_idtaryfa = taryfy_idtaryfa;
    }


    @ManyToOne
    @JoinColumn(name = "taryfy_idtaryfa", nullable = false, insertable = false, updatable = false)
    private Taryfy taryfy;

    public Taryfy getTaryfy() {
        return taryfy;
    }

    public void setTaryfy(Taryfy taryfy) {
        this.taryfy = taryfy;
    }

    /*------------*/


    public Cenniki() {

    }

    public Cenniki(String nazwa, String opis, String cena) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
    }

    public Long getIdcennik() {
        return idcennik;
    }

    public void setIdcennik(Long idcennik) {
        this.idcennik = idcennik;
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

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }
}
