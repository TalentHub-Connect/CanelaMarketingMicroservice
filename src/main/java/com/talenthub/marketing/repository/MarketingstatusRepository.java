package com.talenthub.marketing.repository;

import com.talenthub.marketing.model.Marketingstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MarketingstatusRepository extends JpaRepository<Marketingstatus, Integer>, JpaSpecificationExecutor<Marketingstatus> {

    public List<Marketingstatus> findByDescription(String description);

}