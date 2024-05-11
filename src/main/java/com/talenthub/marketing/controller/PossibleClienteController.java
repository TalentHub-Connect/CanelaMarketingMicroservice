package com.talenthub.marketing.controller;

import com.talenthub.marketing.model.Possibleclient;
import com.talenthub.marketing.service.PossibleClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/possibleclient")
public class PossibleClienteController {

    @Autowired
    PossibleClienteService possibleClienteService;

    @CrossOrigin
    @PostMapping("/send")
    public Possibleclient savePossibleclient(@RequestBody Possibleclient possibleCliente) {
        System.out.println(possibleCliente);
        return possibleClienteService.savePossibleclient(possibleCliente);
    }

    @CrossOrigin
    @GetMapping("/list")
    public List<Possibleclient> findAll(){
        return possibleClienteService.findAll();
    }

}
