package com.kpq.store.shopping.repository;

import com.kpq.store.shopping.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
