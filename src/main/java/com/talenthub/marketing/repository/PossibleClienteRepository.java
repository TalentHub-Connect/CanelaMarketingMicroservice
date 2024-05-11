package com.talenthub.marketing.repository;

import com.talenthub.marketing.model.Possibleclient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PossibleClienteRepository extends JpaRepository<Possibleclient, String>, JpaSpecificationExecutor<Possibleclient> {

}