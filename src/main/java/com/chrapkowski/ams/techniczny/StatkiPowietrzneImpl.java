package com.chrapkowski.ams.techniczny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StatkiPowietrzneImpl implements StatkiPowietrzneService {
    @Autowired
    private StatkiPowietrzneRepository statkiPowietrzneRepository;

    //Lista wszytskich statków powietrznych
    @Override
    public List<StatkiPowietrzne> getAllStatkiPowietrzne(){
        return statkiPowietrzneRepository.findAll();
    }

/*@Query("select * from statki_powietrzne")
public List<StatkiPowietrzne> getAllStatkiPowietrzne(){
    return getAllStatkiPowietrzne();
}*/


    //Zapis nowo dodanego statku powietrznego
    @Override
    public void saveStatkiPowietrzne(StatkiPowietrzne statkiPowietrzne) {
        this.statkiPowietrzneRepository.save(statkiPowietrzne);
    }

    // Edycja zapisanego w BD statku powietrznego
    @Override
    public StatkiPowietrzne getStatkiPowietrzneById(long id){
        Optional<StatkiPowietrzne> optional = statkiPowietrzneRepository.findById(id);
        StatkiPowietrzne statkiPowietrzne = null;
        if(optional.isPresent()){
            statkiPowietrzne = optional.get();
        }else {
            throw new RuntimeException("Statku Powietrznego nie znaleziono o id ::" + id);
        }
        return statkiPowietrzne;
    }

    @Override
    public void deleteStatkiPowietrzneById(long id) {
        this.statkiPowietrzneRepository.deleteById(id);
    }
}
