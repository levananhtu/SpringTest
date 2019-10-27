package com.lvat.SpringTest.accessingdatamysql.repositories;

import com.lvat.SpringTest.accessingdatamysql.entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
}
