package com.kodlamaio.invoiceservice.kafka;


import com.kodlamaio.commonpackage.events.rental.RentalCreatedEvent;
import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.business.dto.requests.create.CreateInvoiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

@RequiredArgsConstructor
public class RentalConsumer {
    private final InvoiceService service;
    private final ModelMapperService mapper;

    @KafkaListener(
            topics = "rental-created",
            groupId = "invoice-rental-created"
    )
    public void consume(RentalCreatedEvent event) {

        CreateInvoiceRequest rental = mapper.forRequest().map(event,CreateInvoiceRequest.class);
        service.add(rental);

    }
}
