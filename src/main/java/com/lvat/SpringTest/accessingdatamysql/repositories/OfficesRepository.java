package com.lvat.SpringTest.accessingdatamysql.repositories;

import com.lvat.SpringTest.accessingdatamysql.entities.Offices;
import org.springframework.data.repository.CrudRepository;

public interface OfficesRepository extends CrudRepository<Offices, Long> {
}
