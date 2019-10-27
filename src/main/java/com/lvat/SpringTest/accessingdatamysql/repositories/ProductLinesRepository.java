package com.lvat.SpringTest.accessingdatamysql.repositories;

import com.lvat.SpringTest.accessingdatamysql.entities.ProductLines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLinesRepository extends JpaRepository<ProductLines, Long> {
}
