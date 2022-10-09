package com.chrapkowski.ams.techniczny;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatkiPowietrzneRepository extends JpaRepository<StatkiPowietrzne,Long> {

}
