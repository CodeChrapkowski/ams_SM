package com.chrapkowski.ams.administracja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaryfyRepository extends JpaRepository<Taryfy, Long> {

    /*Filtowanie wyników tabeli*/
    @Query(value = "select * from Taryfy t where t.nazwa like %:keyword% or t.opis like %:keyword%", nativeQuery = true)
    List<Taryfy> findByKeyword(@Param("keyword") String keyword);
}