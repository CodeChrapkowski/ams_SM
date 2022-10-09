package com.chrapkowski.ams.administracja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CzlonkostwaRepository extends JpaRepository<Czlonkostwa, Long> {

    @Query(value = "select * from Czlonkostwa", nativeQuery = true)
    List<Czlonkostwa> listCzlonkostwa ();
}
