package com.talenthub.marketing.service;

import com.talenthub.marketing.model.Possibleclient;
import com.talenthub.marketing.repository.PossibleClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PossibleClienteService
{
    @Autowired
    PossibleClienteRepository possibleClienteRepository;

    @Autowired
    MarketingStatusService marketingStatusService;
    public Possibleclient savePossibleclient(Possibleclient possibleCliente) {
        possibleCliente.setMarketingstatusid(marketingStatusService.findById(1).getId());
        possibleClienteRepository.save(possibleCliente);
        return possibleCliente;
    }
}

