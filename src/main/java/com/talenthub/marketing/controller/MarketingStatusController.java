package com.talenthub.marketing.controller;

import com.talenthub.marketing.model.Marketingstatus;
import com.talenthub.marketing.service.MarketingStatusService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marketingstatus")
public class MarketingStatusController {

    @Autowired
    MarketingStatusService marketingStatusService;

    @CrossOrigin
    @GetMapping("/list")
    public List<Marketingstatus> findAll(){
        return marketingStatusService.findAll();
    }

    @CrossOrigin
    @PostMapping("/save")
    public Marketingstatus save(@RequestBody Marketingstatus estado){
        return marketingStatusService.save(estado);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public Boolean save(@PathVariable Integer id){
        return marketingStatusService.deleteById(id);
    }


}
