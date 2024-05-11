package com.talenthub.marketing.service;

import com.talenthub.marketing.model.Marketingstatus;
import com.talenthub.marketing.repository.MarketingstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingStatusService {
    @Autowired
    MarketingstatusRepository marketingstatusRepository;

    Marketingstatus findById(int id){
        return marketingstatusRepository.findById(id).get();
    }

    public List<Marketingstatus> findAll() {
        return marketingstatusRepository.findAll();
    }

    public Marketingstatus save(Marketingstatus estado) {
        if(marketingstatusRepository.findByDescription(estado.getDescription()).size() == 0){
            return marketingstatusRepository.save(estado);
        }
        System.out.println("Estado ya existente: ");
        System.out.println(estado.toString());
        return null;
    }

    public Boolean deleteById(Integer id) {
        try{
            this.marketingstatusRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
