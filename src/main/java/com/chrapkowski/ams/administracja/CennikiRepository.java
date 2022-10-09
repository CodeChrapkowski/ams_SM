package com.chrapkowski.ams.administracja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CennikiRepository extends JpaRepository<Cenniki, Long> {

}
