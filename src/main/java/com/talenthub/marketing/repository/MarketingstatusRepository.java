package com.talenthub.marketing.repository;

import com.talenthub.marketing.model.Marketingstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MarketingstatusRepository extends JpaRepository<Marketingstatus, Integer>, JpaSpecificationExecutor<Marketingstatus> {

}