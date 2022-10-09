package com.chrapkowski.ams.administracja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CzlonkostwaImpl implements CzlonkostwaService {

    @Autowired
    private CzlonkostwaRepository czlonkostwaRepository;

    @Override
    public List<Czlonkostwa> listCzlonkostwa() {
        return this.czlonkostwaRepository.listCzlonkostwa();
    }
}
