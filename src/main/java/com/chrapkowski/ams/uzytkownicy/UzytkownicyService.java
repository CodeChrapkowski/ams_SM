package com.chrapkowski.ams.uzytkownicy;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UzytkownicyService extends UserDetailsService {
    Uzytkownicy save(UzytkownicyRegistrationDto registrationDto);

    List<Uzytkownicy> getAllUzytkownicy();
}

