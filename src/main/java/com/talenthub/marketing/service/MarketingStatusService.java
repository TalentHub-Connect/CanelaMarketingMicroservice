package com.talenthub.marketing.service;

import com.talenthub.marketing.model.Marketingstatus;
import com.talenthub.marketing.repository.MarketingstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketingStatusService {
    @Autowired
    MarketingstatusRepository marketingstatusRepository;

    Marketingstatus findById(int id){
        return marketingstatusRepository.findById(id).get();
    }
}
