package com.chrapkowski.ams.administracja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaryfyImpl implements TaryfyService {

    @Autowired
    private TaryfyRepository taryfyRepository;

    @Override
    public List<Taryfy> PokazWszystkieTaryfy() {
        return taryfyRepository.findAll();
    }

    @Override
    public void ZapiszTaryfe(Taryfy taryfy) {
        this.taryfyRepository.save(taryfy);
    }

    @Override
    public Taryfy AktualizujTaryfePoId(long id) {
        Optional<Taryfy> optional = taryfyRepository.findById(id);
        Taryfy taryfy = null;
        if (optional.isPresent()) {
            taryfy = optional.get();
        } else {
            throw new RuntimeException("Nie znaleziono taryfy o id :" + id);
        }
        return taryfy;
    }

    @Override
    public void UsunTaryfePoId(long id) {
        this.taryfyRepository.deleteById(id);
    }

    @Override
    public Page<Taryfy> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection ) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.taryfyRepository.findAll(pageable);
    }

    public List<Taryfy> findByKeyword(String keyword) {
        return this.taryfyRepository.findByKeyword(keyword);
    }
}
