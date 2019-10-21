package com.lvat.SpringTest.accessingdatamysql.repositories;

import com.lvat.SpringTest.accessingdatamysql.entities.ProductLines;
import org.springframework.data.repository.CrudRepository;

public interface ProductLinesRepository extends CrudRepository<ProductLines, Long> {
}
