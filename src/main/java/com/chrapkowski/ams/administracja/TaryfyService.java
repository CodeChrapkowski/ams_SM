package com.chrapkowski.ams.administracja;


import org.springframework.data.domain.Page;

import java.util.List;

public interface TaryfyService {
    List<Taryfy> PokazWszystkieTaryfy();

    void ZapiszTaryfe(Taryfy taryfy);

    Taryfy AktualizujTaryfePoId(long id);

    void UsunTaryfePoId(long id);

    Page<Taryfy> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    //Get taryfy by keyword
    List<Taryfy> findByKeyword (String keyword);
}
