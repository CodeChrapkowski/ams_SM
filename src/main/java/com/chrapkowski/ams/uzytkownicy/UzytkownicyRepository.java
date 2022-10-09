package com.chrapkowski.ams.uzytkownicy;

import com.chrapkowski.ams.uzytkownicy.Uzytkownicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzytkownicyRepository extends JpaRepository<Uzytkownicy, Long> {
    Uzytkownicy findByEmail(String email);
 

}
