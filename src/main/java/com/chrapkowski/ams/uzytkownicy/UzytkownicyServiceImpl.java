package com.chrapkowski.ams.uzytkownicy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UzytkownicyServiceImpl implements UzytkownicyService {

    @Autowired
    private UzytkownicyRepository uzytkownicyRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UzytkownicyServiceImpl(UzytkownicyRepository uzytkownicyRepository) {
        super();
        this.uzytkownicyRepository = uzytkownicyRepository;
    }

    @Override
    public Uzytkownicy save(UzytkownicyRegistrationDto registrationDto) {
        Uzytkownicy uzytkownicy = new Uzytkownicy(
                registrationDto.getImie(),
                registrationDto.getNazwisko(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getHaslo()),
                Arrays.asList(new Role("ROLE_UZYTKOWNICY")));

        return uzytkownicyRepository.save(uzytkownicy);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Uzytkownicy uzytkownicy = uzytkownicyRepository.findByEmail(username);
        if (uzytkownicy == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(uzytkownicy.getEmail(), uzytkownicy.getHaslo(), mapRolesToAuthorities(uzytkownicy.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNazwa())).collect(Collectors.toList());

    }

    // Lista wszystkich uztykowników
    @Override
    public List<Uzytkownicy> getAllUzytkownicy() {
        return uzytkownicyRepository.findAll();

    }

}
