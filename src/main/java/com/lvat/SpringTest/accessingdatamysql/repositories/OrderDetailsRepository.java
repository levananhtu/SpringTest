package com.lvat.SpringTest.accessingdatamysql.repositories;

import com.lvat.SpringTest.accessingdatamysql.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
