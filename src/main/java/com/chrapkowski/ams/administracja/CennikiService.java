package com.chrapkowski.ams.administracja;

import org.springframework.data.domain.Page;

import java.util.List;

public interface CennikiService {

    List<Cenniki> PokazWszystkieCenniki();

    void ZapiszCennik(Cenniki cenniki);

    Cenniki EdytuTaryfePoId(long id);

    void UsunCennikPoId(long id);
    /* Paginacja*/
 /*       Page<Cenniki> findPaginated(int pageNo, int pageSize);*/

    /*Paginacja ze sortowwaniem kolumn*/
    Page<Cenniki> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
