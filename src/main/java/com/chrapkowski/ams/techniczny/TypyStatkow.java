package com.chrapkowski.ams.techniczny;

import com.chrapkowski.ams.administracja.Cenniki;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "typy_statkow")
public class TypyStatkow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtypstatku;
    private String nazwa;
    private String opis;
    private String data_dodania;

    /*-----------*/

    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "typy_statkow_idtypstatku", referencedColumnName = "idtypstatku")
    List<StatkiPowietrzne> StatkiPowietrznes = new ArrayList<>();

    public List<StatkiPowietrzne> getStatkiPowietrznes() {
        return StatkiPowietrznes;
    }

    public void setStatkiPowietrznes(List<StatkiPowietrzne> statkiPowietrznes) {
      /*było brak this.*/  this.StatkiPowietrznes = statkiPowietrznes;
    }

    /*-----------*/


    public TypyStatkow() {

    }

/*
    public TypyStatkow(String nazwa, String opis, String data_dodania) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.data_dodania = data_dodania;
    }
*/

    public Long getIdtypstatku() {
        return idtypstatku;
    }

    public void setIdtypstatku(Long idtypstatku) {
        this.idtypstatku = idtypstatku;
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

    public String getData_dodania() {
        return data_dodania;
    }

    public void setData_dodania(String data_dodania) {
        this.data_dodania = data_dodania;
    }
}
