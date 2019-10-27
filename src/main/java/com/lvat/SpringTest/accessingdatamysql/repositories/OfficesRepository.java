package com.lvat.SpringTest.accessingdatamysql.repositories;

import com.lvat.SpringTest.accessingdatamysql.entities.Offices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficesRepository extends JpaRepository<Offices, Long> {
}
