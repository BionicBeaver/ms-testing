package com.demo.app.shoppingservice.repository;

import com.demo.app.shoppingservice.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
