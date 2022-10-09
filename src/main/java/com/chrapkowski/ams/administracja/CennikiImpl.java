package com.chrapkowski.ams.administracja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CennikiImpl implements CennikiService {

    @Autowired
    private CennikiRepository cennikiRepository;

    @Autowired
    private TaryfyRepository taryfyRepository;

    @Override
    public List<Cenniki> PokazWszystkieCenniki() {
        return cennikiRepository.findAll();
    }

    @Override
    public void ZapiszCennik(Cenniki cenniki) {
        this.cennikiRepository.save(cenniki);
    }

    @Override
    public Cenniki EdytuTaryfePoId(long id) {
        Optional<Cenniki> optional = cennikiRepository.findById(id);
        Cenniki cenniki = null;
        if (optional.isPresent()) {
            cenniki = optional.get();
        } else {
            throw new RuntimeException("Nie znaleziono cennika o id: " + id);
        }
        return cenniki;
    }

    @Override
    public void UsunCennikPoId(long id) {
        this.cennikiRepository.deleteById(id);
    }


    /*Paginacja wyników*/
 /*   @Override
    public Page<Cenniki> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1,pageSize);

        return this.cennikiRepository.findAll(pageable);
    }*/

    @Override
    public Page<Cenniki> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.cennikiRepository.findAll(pageable);
    }
}
