package com.chrapkowski.ams.administracja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SekcjeImpl implements SekcjeService {

    @Autowired
    private SekcjeRepository sekcjeRepository;

    @Override
    public List<Sekcje> listSekcje() {
        return this.sekcjeRepository.listSekcje();
    }

    @Override
    public void ZapiszSekcje(Sekcje sekcje) {
        this.sekcjeRepository.save(sekcje);
    }

    @Override
    public List<Sekcje> findByKeyword(String keyword) {
        return this.sekcjeRepository.findByKeyword(keyword);
    }

    @Override
    public List<Sekcje> sprNazwy(String sprnazyw){ return this.sekcjeRepository.sprNazwy(sprnazyw);}
}
