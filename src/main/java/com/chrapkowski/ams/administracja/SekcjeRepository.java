package com.chrapkowski.ams.administracja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SekcjeRepository extends JpaRepository<Sekcje, Long> {

    @Query(value = "select * from Sekcje",nativeQuery = true)
    List<Sekcje> listSekcje();

    /*Filtowanie wyników tabeli*/
    @Query(value = "select * from Sekcje  where nazwa like %:keyword% ", nativeQuery = true)
    List<Sekcje> findByKeyword(@Param("keyword") String keyword);

   /* Zapytanie do validacji nazwy*/
    @Query(value = "select nazwa from Sekcje where nazwa like %:sprnazwy%", nativeQuery = true)
    List<Sekcje> sprNazwy(@Param("sprnazwy") String sprnazwy);
}
