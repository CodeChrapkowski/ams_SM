package com.chrapkowski.ams.administracja;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "taryfy")
public class Taryfy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtaryfa;

    @Column(name = "nazwa")
    @Size(min = 5)
    private String nazwa;

    @Column(name = "opis")
    @Size(min = 10)
    private String opis;

    /*---------------*/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "taryfy_idtaryfa", referencedColumnName = "idtaryfa")
    List<Cenniki> Cennikis = new ArrayList<>();


    public List<Cenniki> getCennikis() {
        return Cennikis;
    }

    public void setCennikis(List<Cenniki> Cennikis) {
        this.Cennikis = Cennikis;
    }

/*
    @OneToMany(mappedBy = "taryfy")
    private Set<Cenniki> cenniki;*/

    /*---------------*/

    public Taryfy() {

    }


    public Long getIdtaryfa() {
        return idtaryfa;
    }

    public void setIdtaryfa(Long idtaryfa) {
        this.idtaryfa = idtaryfa;
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
