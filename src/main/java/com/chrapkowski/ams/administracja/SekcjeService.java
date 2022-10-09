package com.chrapkowski.ams.administracja;

import java.util.List;

public interface SekcjeService {

    List<Sekcje> listSekcje();

    void ZapiszSekcje(Sekcje sekcje);

    //Get taryfy by keyword
    List<Sekcje> findByKeyword (String keyword);

    List<Sekcje> sprNazwy (String sprnazwy);
}
