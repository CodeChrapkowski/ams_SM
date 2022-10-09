package com.chrapkowski.ams.techniczny;

import java.util.List;

public interface StatkiPowietrzneService {
    List<StatkiPowietrzne> getAllStatkiPowietrzne();
    void saveStatkiPowietrzne(StatkiPowietrzne statkiPowietrzne);
    StatkiPowietrzne getStatkiPowietrzneById(long id);
    void deleteStatkiPowietrzneById(long id);

}
