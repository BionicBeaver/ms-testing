package com.demo.app.shoppingservice.service;

import com.demo.app.shoppingservice.entity.Invoice;
import com.demo.app.shoppingservice.repository.InvoiceItemsRepository;
import com.demo.app.shoppingservice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceItemsRepository invoiceItemsRepository;

    @Override
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceDB=invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
        if(invoiceDB!=null) {
            return invoiceDB;
        }
        invoice.setState("CREATED");
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice invoiceDB=getInvoice(invoice.getId());
        if(invoiceDB==null) {
            return null;
        }
        invoiceDB.setCustomerId(invoice.getCustomerId());
        invoice.setDescription(invoice.getDescription());
        invoice.setNumberInvoice(invoice.getNumberInvoice());
        invoice.getItems().clear();
        invoiceDB.setItems(invoice.getItems());
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceDB=getInvoice(invoice.getId());
        if(invoiceDB==null) {
            return null;
        }
        invoiceDB.setState("DELETED");
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }
}
