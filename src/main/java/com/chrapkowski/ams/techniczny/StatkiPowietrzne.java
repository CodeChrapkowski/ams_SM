package com.chrapkowski.ams.techniczny;

import com.chrapkowski.ams.administracja.Taryfy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "statki_powietrzne")
public class StatkiPowietrzne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_statek_powietrzny;

    @NotEmpty
    private String nazwa;
    @NotEmpty
    private String opis;
    @NotEmpty
    private String rejestracja;
    @NotEmpty
    private String znaki;

    private String data_dodania;
    private String typy_statkow_idtypstatku;


    public StatkiPowietrzne() {

    }

    public StatkiPowietrzne(Long id_statek_powietrzny, String nazwa, String opis, String rejestracja, String znaki, String data_dodania) {
        this.id_statek_powietrzny = id_statek_powietrzny;
        this.nazwa = nazwa;
        this.opis = opis;
        this.rejestracja = rejestracja;
        this.znaki = znaki;
        this.data_dodania = data_dodania;
    }

    /*    --------------*/
    @ManyToOne
    @JoinColumn(name = "typy_statkow_idtypstatku", nullable = false, insertable = false, updatable = false)
    private TypyStatkow typyStatkow;

    public TypyStatkow getTypyStatkow() {
        return typyStatkow;
    }

    public void setTypyStatkow(TypyStatkow typyStatkow) {
        this.typyStatkow = typyStatkow;
    }


    /* -------------------*/


    public Long getId_statek_powietrzny() {
        return id_statek_powietrzny;
    }

    public void setId_statek_powietrzny(Long id_statek_powietrzny) {
        this.id_statek_powietrzny = id_statek_powietrzny;
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

    public String getRejestracja() {
        return rejestracja;
    }

    public void setRejestracja(String rejestracja) {
        this.rejestracja = rejestracja;
    }

    public String getZnaki() {
        return znaki;
    }

    public void setZnaki(String zanki) {
        this.znaki = zanki;
    }

    public String getData_dodania() {
        return data_dodania;
    }

    public void setData_dodania(String data_dodania) {
        this.data_dodania = data_dodania;
    }

    public String getTypy_statkow_idtypstatku() {
        return typy_statkow_idtypstatku;
    }

    public void setTypy_statkow_idtypstatku(String typy_statkow_idtypstatku) {
        this.typy_statkow_idtypstatku = typy_statkow_idtypstatku;
    }
}
