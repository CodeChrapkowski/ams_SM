package com.chrapkowski.ams.administracja;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pracownicy")
public class Pracownicy {

    @Id
    private Long idpracownik;
    private String imie;
    private String nazwisko;
    private String dataur;
    private Integer pesel;
    private String kodpocztowy;
    private String miasto;
    private String ulica;
    private String nrbudynku;
    private String nrlokalu;
    private String poczta;
    private Integer tel;

    public Pracownicy() {

    }

    public Pracownicy(String imie, String nazwisko, String dataur, Integer pesel, String kodpocztowy, String miasto,
                      String ulica, String nrbudynku, String nrlokalu, String poczta, Integer tel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataur = dataur;
        this.pesel = pesel;
        this.kodpocztowy = kodpocztowy;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrbudynku = nrbudynku;
        this.nrlokalu = nrlokalu;
        this.poczta = poczta;
        this.tel = tel;
    }

    public Long getIdpracownik() {
        return idpracownik;
    }

    public void setIdpracownik(Long idpracownik) {
        this.idpracownik = idpracownik;
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

    public String getDataur() {
        return dataur;
    }

    public void setDataur(String dataur) {
        this.dataur = dataur;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrbudynku() {
        return nrbudynku;
    }

    public void setNrbudynku(String nrbudynku) {
        this.nrbudynku = nrbudynku;
    }

    public String getNrlokalu() {
        return nrlokalu;
    }

    public void setNrlokalu(String nrlokalu) {
        this.nrlokalu = nrlokalu;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}
